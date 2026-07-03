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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalysisFlowScreen(
    onCancel: () -> Unit,
    onFinish: () -> Unit
) {
    var currentStep by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while (currentStep < 6) {
            kotlinx.coroutines.delay(1500)
            currentStep++
        }
        onFinish()
    }

    fun getStatus(index: Int): StepStatus {
        return when {
            index < currentStep -> StepStatus.Completed
            index == currentStep -> StepStatus.Active
            else -> StepStatus.Pending
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("عدالة الذكاء", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary) },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Person, contentDescription = "Profile", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text("جاري تحليل المستند", style = MaterialTheme.typography.displayLarge, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(8.dp))
            Text("الذكاء الاصطناعي يقوم بمعالجة العقد الخاص بك لاستخراج المخاطر والبنود الرئيسية.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(32.dp))
            
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    StepItem(
                        icon = Icons.Outlined.CloudDone,
                        title = "رفع المستند",
                        subtitle = if (getStatus(0) == StepStatus.Completed) "اكتمل رفع الملف (2.4 MB)" else "جاري رفع الملف...",
                        status = getStatus(0)
                    )
                }
                item {
                    StepItem(
                        icon = Icons.Outlined.DocumentScanner,
                        title = "التعرف البصري (OCR)",
                        subtitle = if (getStatus(1) == StepStatus.Completed) "تم تحويل النص بنجاح" else "قيد المعالجة...",
                        status = getStatus(1)
                    )
                }
                item {
                    StepItem(
                        icon = Icons.Outlined.FormatListBulleted,
                        title = "تجزئة البنود",
                        subtitle = if (getStatus(2) == StepStatus.Completed) "تم فصل البنود" else "جاري فصل المواد والأحكام القانونية...",
                        status = getStatus(2)
                    )
                }
                item {
                    StepItem(
                        icon = Icons.Outlined.Category,
                        title = "تصنيف البنود",
                        subtitle = if (getStatus(3) == StepStatus.Completed) "تم التصنيف" else "قيد الانتظار",
                        status = getStatus(3)
                    )
                }
                item {
                    StepItem(
                        icon = Icons.Outlined.Warning,
                        title = "اكتشاف المخاطر",
                        subtitle = if (getStatus(4) == StepStatus.Completed) "تم اكتشاف المخاطر" else "قيد الانتظار",
                        status = getStatus(4)
                    )
                }
                item {
                    StepItem(
                        icon = Icons.Outlined.Summarize,
                        title = "إصدار الملخص",
                        subtitle = "الخطوة النهائية",
                        status = getStatus(5)
                    )
                }
            }
            
            Button(
                onClick = onCancel,
                modifier = Modifier.padding(vertical = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
            ) {
                Text("إلغاء التحليل", modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
            }
        }
    }
}

enum class StepStatus {
    Completed, Active, Pending
}

@Composable
fun StepItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    status: StepStatus
) {
    val opacity = if (status == StepStatus.Pending) 0.5f else 1f
    val iconColor = when (status) {
        StepStatus.Completed -> com.example.ui.theme.Success
        StepStatus.Active -> MaterialTheme.colorScheme.primary
        StepStatus.Pending -> MaterialTheme.colorScheme.onSurfaceVariant
    }
    val iconBgColor = when (status) {
        StepStatus.Completed -> com.example.ui.theme.Success.copy(alpha = 0.2f)
        StepStatus.Active -> MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
        StepStatus.Pending -> MaterialTheme.colorScheme.surfaceVariant
    }
    
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(iconBgColor, CircleShape)
                .border(1.dp, iconColor.copy(alpha = 0.5f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = iconColor)
        }
        
        Row(
            modifier = Modifier
                .weight(1f)
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f * opacity), RoundedCornerShape(12.dp))
                .border(1.dp, if (status == StepStatus.Active) MaterialTheme.colorScheme.primary.copy(alpha = 0.5f) else Color.White.copy(alpha = 0.1f * opacity), RoundedCornerShape(12.dp))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold, color = if (status == StepStatus.Active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = opacity))
                Text(subtitle, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = opacity))
                
                if (status == StepStatus.Active) {
                    Spacer(modifier = Modifier.height(12.dp))
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth().height(6.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
            if (status == StepStatus.Completed) {
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = com.example.ui.theme.Success, modifier = Modifier.padding(start = 8.dp))
            } else if (status == StepStatus.Active) {
                CircularProgressIndicator(modifier = Modifier.size(24.dp).padding(start = 8.dp), color = MaterialTheme.colorScheme.primary, strokeWidth = 2.dp)
            }
        }
    }
}
