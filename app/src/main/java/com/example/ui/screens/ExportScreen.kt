package com.example.ui.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
fun ExportScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("تصدير التقرير", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Back", tint = MaterialTheme.colorScheme.primary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
                )
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
                    .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.1f))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Download, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("تصدير التقرير الآن", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .background(MaterialTheme.colorScheme.surfaceContainerHighest)
                    ) {
                        // Placeholder for image
                        Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)))
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp)
                        ) {
                            Text("عقد شراكة استراتيجية.pdf", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Icon(Icons.Outlined.InsertDriveFile, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(16.dp))
                                Text("تم التحليل بواسطة الذكاء الاصطناعي", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                    
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceDim.copy(alpha = 0.5f))
                            .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.1f))
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("85%", style = MaterialTheme.typography.displayLarge, color = MaterialTheme.colorScheme.primary)
                            Text("درجة الأمان", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Divider(modifier = Modifier.height(40.dp).width(1.dp), color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("24", style = MaterialTheme.typography.displayLarge, color = MaterialTheme.colorScheme.onSurface)
                            Text("بند قانوني", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Divider(modifier = Modifier.height(40.dp).width(1.dp), color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("اليوم", style = MaterialTheme.typography.displayLarge, color = MaterialTheme.colorScheme.onSurface)
                            Text("تاريخ التحليل", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
            
            item {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(bottom = 8.dp)) {
                    Icon(Icons.Outlined.Tune, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Text("تخصيص المحتوى", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                }
                
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.7f), RoundedCornerShape(12.dp))
                        .border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                ) {
                    ToggleItem(Icons.Outlined.Summarize, "الملخص التنفيذي", "أهم النقاط بصيغة مختصرة", MaterialTheme.colorScheme.primary, true)
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.1f))
                    ToggleItem(Icons.Outlined.Warning, "خريطة المخاطر", "تقييم الثغرات المحتملة", com.example.ui.theme.Warning, true)
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.1f))
                    ToggleItem(Icons.Outlined.ListAlt, "تحليل مفصل للبنود", "مراجعة شاملة لكل بند", MaterialTheme.colorScheme.secondary, true)
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.1f))
                    ToggleItem(Icons.Outlined.Lightbulb, "توصيات الذكاء الاصطناعي", "اقتراحات للتعديل والتحسين", com.example.ui.theme.Success, false)
                }
            }
            
            item {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(bottom = 8.dp)) {
                    Icon(Icons.Outlined.IosShare, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Text("خيارات التصدير", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                }
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ExportOptionCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.PictureAsPdf,
                        title = "PDF احترافي",
                        isPremium = true
                    )
                    ExportOptionCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.AddToDrive,
                        title = "جوجل درايف",
                        isPremium = false
                    )
                    ExportOptionCard(
                        modifier = Modifier.weight(1f),
                        icon = Icons.Outlined.Share,
                        title = "مشاركة",
                        isPremium = false
                    )
                }
            }
        }
    }
}

@Composable
fun ToggleItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    iconColor: Color,
    isChecked: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(32.dp).background(iconColor.copy(alpha = 0.2f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(20.dp))
            }
            Column {
                Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.onSurface)
                Text(subtitle, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Switch(
            checked = isChecked,
            onCheckedChange = null,
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colorScheme.onPrimaryContainer,
                checkedTrackColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

@Composable
fun ExportOptionCard(
    modifier: Modifier = Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    isPremium: Boolean
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(
                if (isPremium) MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) else MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                if (isPremium) MaterialTheme.colorScheme.primary.copy(alpha = 0.4f) else Color.White.copy(alpha = 0.1f),
                RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isPremium) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 8.dp, y = (-8).dp)
                    .background(com.example.ui.theme.Warning, RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(Icons.Filled.Star, contentDescription = null, tint = MaterialTheme.colorScheme.surface, modifier = Modifier.size(12.dp))
                Text("Premium", style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp), color = MaterialTheme.colorScheme.surface, fontWeight = FontWeight.Bold)
            }
        }
        
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(icon, contentDescription = null, tint = if (isPremium) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(32.dp))
            Text(title, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface, fontWeight = if (isPremium) FontWeight.SemiBold else FontWeight.Medium)
        }
    }
}
