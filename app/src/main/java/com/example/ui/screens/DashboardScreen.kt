package com.example.ui.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen(
    onNavigateToChat: () -> Unit,
    onNavigateToUpload: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 80.dp, bottom = 100.dp), // Space for top and bottom bars
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "مرحباً، أحمد",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "لديك 3 عقود قيد التحليل و 2 تتطلب انتباهك.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Outlined.DocumentScanner,
                    label = "مسح مستند",
                    iconColor = MaterialTheme.colorScheme.primary,
                    iconBgColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                    onClick = onNavigateToUpload
                )
                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Outlined.UploadFile,
                    label = "رفع ملف",
                    iconColor = MaterialTheme.colorScheme.secondary,
                    iconBgColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.2f),
                    onClick = onNavigateToUpload
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Outlined.CloudDownload,
                    label = "استيراد من السحابة",
                    iconColor = MaterialTheme.colorScheme.tertiary,
                    iconBgColor = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.2f),
                    onClick = onNavigateToUpload
                )
                QuickActionCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Add,
                    label = "عقد جديد",
                    iconColor = MaterialTheme.colorScheme.onPrimary,
                    iconBgColor = MaterialTheme.colorScheme.primary,
                    isHighlight = true,
                    onClick = onNavigateToUpload
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "التحليلات الأخيرة",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                TextButton(onClick = { /*TODO*/ }) {
                    Text("عرض الكل", color = MaterialTheme.colorScheme.primary)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            
            // High Risk Contract
            ContractCard(
                title = "عقد إيجار تجاري - الرياض",
                time = "تم التحديث منذ ساعتين",
                status = "مخاطر عالية",
                statusColor = MaterialTheme.colorScheme.error,
                statusBg = MaterialTheme.colorScheme.errorContainer,
                onClick = onNavigateToChat
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            // Processing Contract
            ContractCard(
                title = "اتفاقية عدم إفصاح NDA",
                time = "جاري التحليل بواسطة الذكاء الاصطناعي...",
                status = "قيد المعالجة",
                statusColor = MaterialTheme.colorScheme.onSurfaceVariant,
                statusBg = MaterialTheme.colorScheme.surfaceVariant,
                isProcessing = true,
                onClick = onNavigateToChat
            )
        }

        item {
            Text(
                text = "اقتراحات الذكاء الاصطناعي",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SuggestionItem(
                    icon = Icons.Outlined.Lightbulb,
                    iconColor = MaterialTheme.colorScheme.primary,
                    title = "تحديث بند القوة القاهرة",
                    description = "بناءً على التعديلات الأخيرة في نظام المعاملات المدنية، يُنصح بتحديث صياغة بند القوة القاهرة.",
                    actionText = "عرض التفاصيل"
                )
                Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
                SuggestionItem(
                    icon = Icons.Outlined.Insights,
                    iconColor = MaterialTheme.colorScheme.secondary,
                    title = "نمط متكرر: غرامات التأخير",
                    description = "لاحظنا أن 40% من عقودك الأخيرة تفتقر إلى وضوح في بنود غرامات التأخير.",
                    actionText = "إنشاء قالب"
                )
            }
        }
    }
}

@Composable
fun QuickActionCard(
    modifier: Modifier = Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    iconColor: Color,
    iconBgColor: Color,
    isHighlight: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(
                color = if (isHighlight) MaterialTheme.colorScheme.primary.copy(alpha = 0.05f) else MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = if (isHighlight) MaterialTheme.colorScheme.primary.copy(alpha = 0.3f) else Color.White.copy(alpha = 0.1f),
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(iconBgColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = if (isHighlight) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
            fontWeight = if (isHighlight) FontWeight.Bold else FontWeight.Medium
        )
    }
}

@Composable
fun ContractCard(
    title: String,
    time: String,
    status: String,
    statusColor: Color,
    statusBg: Color,
    isProcessing: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.6f),
                shape = RoundedCornerShape(12.dp)
            )
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isProcessing) Icons.Outlined.SmartToy else Icons.Outlined.Description,
                        contentDescription = null,
                        tint = if (isProcessing) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = time,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (isProcessing) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Box(
                modifier = Modifier
                    .background(statusBg, CircleShape)
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    if (status == "مخاطر عالية") {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = statusColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = status,
                        style = MaterialTheme.typography.labelSmall,
                        color = statusColor
                    )
                }
            }
        }
        
        if (isProcessing) {
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth().height(6.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceContainerHighest
            )
        } else {
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("الثقة", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("92%", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
                }
                Column {
                    Text("البنود المخفية", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("3", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
                }
                Column {
                    Text("الحالة", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("قيد المراجعة", style = MaterialTheme.typography.bodyMedium, color = com.example.ui.theme.Warning)
                }
            }
        }
    }
}

@Composable
fun SuggestionItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color,
    title: String,
    description: String,
    actionText: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.padding(top = 4.dp)
        )
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = actionText,
                style = MaterialTheme.typography.labelSmall,
                color = iconColor,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
