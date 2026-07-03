package com.example.ui.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    onNavigateBack: () -> Unit,
    onNavigateToExport: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                        Text("عقد إيجار تجاري.pdf", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
                        Text("تم التحليل بنجاح", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Back", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                actions = {
                    IconButton(onClick = onNavigateToExport) {
                        Icon(Icons.Outlined.PictureAsPdf, contentDescription = "Export Report", tint = MaterialTheme.colorScheme.primary)
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Options", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
                )
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background.copy(alpha = 0.9f))
                    .padding(16.dp)
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(3) { index ->
                        val text = when(index) {
                            0 -> "صغ رداً لطلب التعديل"
                            1 -> "هل العقد متوافق قانونياً؟"
                            else -> "لخص أهم التزاماتي"
                        }
                        val icon = when(index) {
                            0 -> Icons.Outlined.Edit
                            1 -> Icons.Outlined.Gavel
                            else -> Icons.Outlined.Summarize
                        }
                        SuggestionChip(
                            onClick = { },
                            label = { Text(text) },
                            icon = { Icon(icon, contentDescription = null, modifier = Modifier.size(16.dp)) },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = Color.Transparent,
                                labelColor = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            border = SuggestionChipDefaults.suggestionChipBorder(
                                true,
                                borderColor = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
                            )
                        )
                    }
                }
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Send, contentDescription = "Send", tint = MaterialTheme.colorScheme.primary)
                    }
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("اسأل عن أي بند في العقد...") },
                        modifier = Modifier.weight(1f),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Mic, contentDescription = "Mic", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Row(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f), CircleShape)
                            .border(1.dp, Color.White.copy(alpha = 0.1f), CircleShape)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Outlined.Description, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(16.dp))
                        Text("المساعد يقرأ: عقد إيجار تجاري - النسخة النهائية", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface)
                    }
                }
            }
            
            item {
                AIMessage(
                    text = "مرحباً! لقد قمت بتحليل عقد الإيجار التجاري. لاحظت بعض البنود التي قد تتطلب انتباهك، خاصة فيما يتعلق بـ غرامات التأخير و تجديد العقد التلقائي.\n\nكيف يمكنني مساعدتك في هذا العقد اليوم؟"
                )
            }
            
            item {
                UserMessage(text = "لخص لي بند غرامات التأخير، هل يعتبر مجحفاً؟")
            }
            
            item {
                AIMessageWithCard()
            }
        }
    }
}

@Composable
fun AIMessage(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(16.dp).copy(topEnd = androidx.compose.foundation.shape.CornerSize(0.dp)))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f), RoundedCornerShape(16.dp).copy(topEnd = androidx.compose.foundation.shape.CornerSize(0.dp)))
                .padding(16.dp)
                .weight(1f, fill = false)
        ) {
            Text(text, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.SmartToy, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer, modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun UserMessage(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), RoundedCornerShape(16.dp).copy(topStart = androidx.compose.foundation.shape.CornerSize(0.dp)))
                .border(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f), RoundedCornerShape(16.dp).copy(topStart = androidx.compose.foundation.shape.CornerSize(0.dp)))
                .padding(16.dp)
                .weight(1f, fill = false)
        ) {
            Text(text, style = MaterialTheme.typography.bodyMedium, color = com.example.ui.theme.Primary)
        }
    }
}

@Composable
fun AIMessageWithCard() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(16.dp).copy(topEnd = androidx.compose.foundation.shape.CornerSize(0.dp)))
                .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f), RoundedCornerShape(16.dp).copy(topEnd = androidx.compose.foundation.shape.CornerSize(0.dp)))
                .padding(16.dp)
                .weight(1f, fill = false),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("بناءً على المادة 7 من العقد، إليك ملخص غرامات التأخير:", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
            
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                    .border(1.dp, com.example.ui.theme.Border, RoundedCornerShape(8.dp))
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("المادة 7: غرامات التأخير", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = com.example.ui.theme.Primary)
                Text("\"في حال تأخر الطرف الثاني عن سداد الأجرة المستحقة في موعدها، يلتزم بدفع غرامة تأخير قدرها 5% عن كل أسبوع تأخير، على ألا تتجاوز الغرامة 20% من قيمة الإيجار السنوي.\"", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(Icons.Default.Warning, contentDescription = null, tint = com.example.ui.theme.Warning, modifier = Modifier.size(16.dp))
                Text("تحليل المخاطر:", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = com.example.ui.theme.Warning)
            }
            Text("• نسبة 5% أسبوعياً تعتبر مرتفعة جداً وغير معتادة في العقود المماثلة.\n• الحد الأقصى 20% قد يشكل عبئاً مالياً كبيراً.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("نوصي بالتفاوض لخفض النسبة إلى 1-2% شهرياً.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.SmartToy, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer, modifier = Modifier.size(16.dp))
        }
    }
}
