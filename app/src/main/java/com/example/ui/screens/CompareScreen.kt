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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompareScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("مقارنة العقود", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Back", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text("تحليل الاختلافات بين النسخة الأصلية والمعدلة.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                            .border(1.dp, com.example.ui.theme.Border, RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    ) {
                        Text("النسخة أ (الأصلية)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        Text("عقد_إيجار_2023.pdf", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                    
                    Icon(Icons.Default.CompareArrows, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(horizontal = 8.dp))
                    
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                            .border(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    ) {
                        Text("النسخة ب (المعدلة)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                        Text("عقد_إيجار_معدل.pdf", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    }
                }
            }
            
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                        .border(width = 4.dp, color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp).copy(bottomEnd = androidx.compose.foundation.shape.CornerSize(0.dp), topEnd = androidx.compose.foundation.shape.CornerSize(0.dp))) // Left border mockup
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Icon(Icons.Default.Analytics, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(32.dp))
                        Text("ملخص الذكاء الاصطناعي", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                    }
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("نسبة التطابق", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("85%", style = MaterialTheme.typography.displayLarge, color = com.example.ui.theme.Success)
                        }
                        
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)).padding(8.dp)) {
                                Text("3", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, color = com.example.ui.theme.Danger)
                                Text("عالي الخطورة", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)).padding(8.dp)) {
                                Text("5", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold, color = com.example.ui.theme.Warning)
                                Text("متوسط الخطورة", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                    
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
                    Text("تم العثور على 12 اختلافاً رئيسياً. ركزت التعديلات بشكل أساسي على شروط الإنهاء والمسؤولية المالية، مما يزيد من تعرض الطرف الأول للمخاطر.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(4) { index ->
                        val (text, color, icon) = when (index) {
                            0 -> Triple("الكل (12)", MaterialTheme.colorScheme.primary, null)
                            1 -> Triple("عالي (3)", MaterialTheme.colorScheme.onSurface, com.example.ui.theme.Danger)
                            2 -> Triple("متوسط (5)", MaterialTheme.colorScheme.onSurface, com.example.ui.theme.Warning)
                            else -> Triple("منخفض (4)", MaterialTheme.colorScheme.onSurface, com.example.ui.theme.Success)
                        }
                        
                        val containerColor = if (index == 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
                        val contentColor = if (index == 0) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                        
                        FilterChip(
                            selected = index == 0,
                            onClick = { },
                            label = { 
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                    if (icon != null) {
                                        Box(modifier = Modifier.size(8.dp).background(icon, CircleShape))
                                    }
                                    Text(text)
                                }
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = containerColor,
                                labelColor = contentColor,
                                selectedContainerColor = containerColor,
                                selectedLabelColor = contentColor
                            )
                        )
                    }
                }
            }
            
            // Diff Item
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
                        .border(1.dp, com.example.ui.theme.Border, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(modifier = Modifier.background(com.example.ui.theme.Danger.copy(alpha = 0.2f), RoundedCornerShape(4.dp)).padding(horizontal = 8.dp, vertical = 4.dp)) {
                                Text("عالي الخطورة", style = MaterialTheme.typography.labelSmall, color = com.example.ui.theme.Danger, fontWeight = FontWeight.Bold)
                            }
                            Text("البند الرابع: الإنهاء المبكر", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                        }
                        Icon(Icons.Default.Info, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    }
                    
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column {
                            Text("النسخة أ (الأصلية)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
                            Text("يحق للطرف الأول إنهاء هذا العقد قبل انتهاء مدته بإشعار خطي مدته ستون (60) يوماً، دون تحمل أي غرامات مالية.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        
                        Divider(color = com.example.ui.theme.Border)
                        
                        Column {
                            Text("النسخة ب (المعدلة)", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(bottom = 8.dp))
                            Text("يحق للطرف الأول إنهاء هذا العقد قبل انتهاء مدته بإشعار خطي مدته تسعون (90) يوماً، مع تحمل غرامة تعادل إيجار شهرين.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
                        }
                        
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                                .border(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Icon(Icons.Outlined.TipsAndUpdates, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                            Column {
                                Text("تحليل الذكاء الاصطناعي", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(bottom = 4.dp))
                                Text("هذا التعديل يزيد من التزاماتك المالية بشكل كبير عند الإنهاء المبكر، ويمدد فترة الإشعار المطلوبة، مما يقلل من مرونتك.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }
        }
    }
}
