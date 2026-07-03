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
fun ProfileScreen(
    onLogout: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AraContract", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary) },
                navigationIcon = {
                    Box(modifier = Modifier.padding(start = 16.dp, end = 8.dp)) {
                        Box(modifier = Modifier.size(32.dp).background(MaterialTheme.colorScheme.surfaceVariant, CircleShape).border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f), CircleShape))
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Outlined.Notifications, contentDescription = "Notifications", tint = MaterialTheme.colorScheme.primary)
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {
                        Box(
                            modifier = Modifier
                                .size(96.dp)
                                .background(MaterialTheme.colorScheme.surfaceContainer, CircleShape)
                                .border(2.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f), CircleShape)
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                                .border(1.dp, MaterialTheme.colorScheme.surface, CircleShape)
                                .padding(4.dp)
                        ) {
                            Icon(Icons.Default.Edit, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer, modifier = Modifier.size(16.dp))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("أحمد المحامي", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.padding(vertical = 8.dp)) {
                        Icon(Icons.Outlined.Gavel, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(16.dp))
                        Text("خبير قانوني", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Row(
                        modifier = Modifier
                            .background(com.example.ui.theme.Warning.copy(alpha = 0.2f), RoundedCornerShape(16.dp))
                            .border(1.dp, com.example.ui.theme.Warning.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(Icons.Filled.Stars, contentDescription = null, tint = com.example.ui.theme.Warning, modifier = Modifier.size(14.dp))
                        Text("عضوية Premium", style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold), color = com.example.ui.theme.Warning)
                    }
                }
            }
            
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatCard(modifier = Modifier.weight(1f), icon = Icons.Outlined.Description, iconColor = MaterialTheme.colorScheme.primary, value = "48", label = "العقود")
                    StatCard(modifier = Modifier.weight(1f), icon = Icons.Outlined.Analytics, iconColor = MaterialTheme.colorScheme.secondary, value = "12", label = "التقارير")
                    StatCard(modifier = Modifier.weight(1f), icon = Icons.Filled.WorkspacePremium, iconColor = com.example.ui.theme.Warning, value = "Premium", label = "الخطة")
                }
            }
            
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                        .padding(20.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
                        Column {
                            Text("مساحة التخزين السحابية", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text("2.4 GB", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                                Text("من 10 GB", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.outline)
                            }
                        }
                        Text("24% مستخدم", style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.primary, modifier = Modifier.background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), RoundedCornerShape(4.dp)).padding(horizontal = 8.dp, vertical = 4.dp))
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth().height(8.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                            contentColor = com.example.ui.theme.Primary
                        ),
                        border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
                    ) {
                        Icon(Icons.Outlined.CloudUpload, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("ترقية المساحة")
                    }
                }
            }
            
            item {
                SettingsGroup(
                    title = "إعدادات الحساب",
                    items = listOf(
                        SettingsItem(Icons.Outlined.Person, "بيانات الحساب"),
                        SettingsItem(Icons.Outlined.Password, "تغيير كلمة المرور")
                    )
                )
            }
            
            item {
                SettingsGroup(
                    title = "تفضيلات التطبيق",
                    items = listOf(
                        SettingsItem(Icons.Outlined.Language, "اللغة", trailing = {
                            Row(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(8.dp)).border(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f), RoundedCornerShape(8.dp)).padding(4.dp)) {
                                Box(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceBright, RoundedCornerShape(4.dp)).padding(horizontal = 12.dp, vertical = 4.dp)) {
                                    Text("العربية", style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.onSurface)
                                }
                                Box(modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)) {
                                    Text("EN", style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }
                        }),
                        SettingsItem(Icons.Outlined.DarkMode, "المظهر", trailing = {
                            Switch(
                                checked = true,
                                onCheckedChange = null,
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MaterialTheme.colorScheme.onSurface,
                                    checkedTrackColor = MaterialTheme.colorScheme.primaryContainer
                                )
                            )
                        })
                    )
                )
            }
            
            item {
                SettingsGroup(
                    title = "الدعم والمساعدة",
                    items = listOf(
                        SettingsItem(Icons.Outlined.Help, "مركز المساعدة"),
                        SettingsItem(Icons.Outlined.PrivacyTip, "سياسة الخصوصية")
                    )
                )
            }
            
            item {
                Button(
                    onClick = onLogout,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = com.example.ui.theme.Danger
                    ),
                    shape = RoundedCornerShape(12.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, com.example.ui.theme.Danger.copy(alpha = 0.3f))
                ) {
                    Icon(Icons.Outlined.Logout, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("تسجيل الخروج", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun StatCard(modifier: Modifier = Modifier, icon: androidx.compose.ui.graphics.vector.ImageVector, iconColor: Color, value: String, label: String) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(value, style = MaterialTheme.typography.headlineMedium, color = if(value == "Premium") com.example.ui.theme.Warning else MaterialTheme.colorScheme.onSurface)
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp), color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

data class SettingsItem(val icon: androidx.compose.ui.graphics.vector.ImageVector, val title: String, val trailing: @Composable () -> Unit = { Icon(Icons.Default.ChevronLeft, contentDescription = null, tint = MaterialTheme.colorScheme.outline) })

@Composable
fun SettingsGroup(title: String, items: List<SettingsItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
            .border(1.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.5f))
                .border(1.dp, Color.White.copy(alpha = 0.05f))
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Text(title, style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp, fontWeight = FontWeight.Bold), color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        
        items.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Box(
                        modifier = Modifier.size(32.dp).background(MaterialTheme.colorScheme.surfaceContainer, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(item.icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
                    }
                    Text(item.title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface)
                }
                item.trailing()
            }
            if (index < items.size - 1) {
                Divider(color = Color.White.copy(alpha = 0.05f))
            }
        }
    }
}
