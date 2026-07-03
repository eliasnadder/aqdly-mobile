package com.example.ui.screens



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
fun SearchScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.8f))
                    .border(1.dp, Color.White.copy(alpha = 0.1f))
                    .padding(top = 16.dp, bottom = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Back", tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    
                    TextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("ابحث عن بند، عقد، أو مخاطرة...") },
                        modifier = Modifier
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.surfaceContainerLow.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                            .border(1.dp, com.example.ui.theme.Border, RoundedCornerShape(12.dp)),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        trailingIcon = {
                            Icon(Icons.Default.Search, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Mic, contentDescription = null, tint = com.example.ui.theme.Primary)
                        }
                    )
                }
                
                LazyRow(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        FilterChip(
                            selected = true,
                            onClick = { },
                            label = { Text("الكل") },
                            leadingIcon = { Icon(Icons.Default.AllInclusive, contentDescription = null, modifier = Modifier.size(18.dp)) },
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f),
                                labelColor = com.example.ui.theme.Primary,
                                iconColor = com.example.ui.theme.Primary
                            ),
                            border = FilterChipDefaults.filterChipBorder(enabled = true, selected = true, borderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
                        )
                    }
                    item {
                        FilterChip(
                            selected = false,
                            onClick = { },
                            label = { Text("العقود") },
                            leadingIcon = { Icon(Icons.Outlined.Description, contentDescription = null, modifier = Modifier.size(18.dp)) }
                        )
                    }
                    item {
                        FilterChip(
                            selected = false,
                            onClick = { },
                            label = { Text("البنود") },
                            leadingIcon = { Icon(Icons.Outlined.Article, contentDescription = null, modifier = Modifier.size(18.dp)) }
                        )
                    }
                    item {
                        FilterChip(
                            selected = false,
                            onClick = { },
                            label = { Text("مخاطر عالية") },
                            leadingIcon = { Icon(Icons.Outlined.Warning, contentDescription = null, modifier = Modifier.size(18.dp)) },
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.1f),
                                labelColor = MaterialTheme.colorScheme.error,
                                iconColor = MaterialTheme.colorScheme.error
                            ),
                            border = FilterChipDefaults.filterChipBorder(enabled = true, selected = false, borderColor = MaterialTheme.colorScheme.error.copy(alpha = 0.2f))
                        )
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
            contentPadding = PaddingValues(top = 16.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("عمليات البحث الأخيرة", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onSurface)
                        Text("مسح", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    
                    RecentSearchItem("عقد توريد برمجيات")
                    RecentSearchItem("بند التعويضات")
                    RecentSearchItem("شروط الدفع المتأخر")
                }
            }
            
            item {
                Divider(color = com.example.ui.theme.Border.copy(alpha = 0.5f))
            }
            
            item {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text("النتائج المطابقة", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
                    
                    SearchResultItem(
                        icon = Icons.Outlined.Description,
                        iconColor = com.example.ui.theme.Primary,
                        title = "عقد توريد برمجيات - شركة التقنية",
                        subtitle1 = "منذ يومين",
                        subtitle1Icon = Icons.Outlined.Schedule,
                        subtitle2 = "42 صفحة",
                        riskScore = "75"
                    )
                    
                    SearchResultItem(
                        icon = Icons.Outlined.Article,
                        iconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        title = "بند الغرامات التأخيرية المفرطة",
                        subtitle1 = "عقد صيانة المعدات الثقيلة",
                        subtitle1Icon = Icons.Outlined.FolderOpen,
                        tagText = "مخاطرة عالية",
                        tagColor = MaterialTheme.colorScheme.error,
                        tagBg = MaterialTheme.colorScheme.errorContainer
                    )
                    
                    SearchResultItem(
                        icon = Icons.Outlined.Article,
                        iconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        title = "بند السرية وعدم الإفصاح (NDA)",
                        subtitle1 = "عقد توريد برمجيات - شركة التقنية",
                        subtitle1Icon = Icons.Outlined.FolderOpen,
                        tagText = "مخاطرة منخفضة",
                        tagColor = com.example.ui.theme.Success,
                        tagBg = com.example.ui.theme.Success.copy(alpha = 0.2f),
                        tagIcon = Icons.Default.CheckCircle
                    )
                }
            }
        }
    }
}

@Composable
fun RecentSearchItem(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Outlined.History, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(text, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
        }
        Icon(Icons.Default.NorthWest, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(16.dp))
    }
}

@Composable
fun SearchResultItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    iconColor: Color,
    title: String,
    subtitle1: String,
    subtitle1Icon: androidx.compose.ui.graphics.vector.ImageVector,
    subtitle2: String? = null,
    riskScore: String? = null,
    tagText: String? = null,
    tagColor: Color? = null,
    tagBg: Color? = null,
    tagIcon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Default.Warning
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.6f), RoundedCornerShape(16.dp))
            .border(1.dp, com.example.ui.theme.Border, RoundedCornerShape(16.dp))
            .padding(16.dp)
            .clickable { },
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(12.dp))
                .border(1.dp, com.example.ui.theme.Border.copy(alpha = 0.5f), RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = iconColor)
        }
        
        Column(modifier = Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurface, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(subtitle1Icon, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(14.dp))
                    Text(subtitle1, style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                if (subtitle2 != null) {
                    Text("•", style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text(subtitle2, style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp), color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            if (tagText != null && tagColor != null && tagBg != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .background(tagBg, RoundedCornerShape(16.dp))
                        .border(1.dp, tagColor.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(tagIcon, contentDescription = null, tint = tagColor, modifier = Modifier.size(12.dp))
                    Text(tagText, style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp, fontWeight = FontWeight.Bold), color = tagColor)
                }
            }
        }
        
        if (riskScore != null) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(com.example.ui.theme.Warning.copy(alpha = 0.1f), CircleShape)
                    .border(2.dp, com.example.ui.theme.Warning, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(riskScore, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold), color = com.example.ui.theme.Warning)
            }
        }
    }
}
