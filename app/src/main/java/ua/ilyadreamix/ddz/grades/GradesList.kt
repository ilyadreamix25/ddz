package ua.ilyadreamix.ddz.grades

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import ua.ilyadreamix.ddz.R
import ua.ilyadreamix.ddz.etc.DDZDimen
import ua.ilyadreamix.ddz.etc.changeAlphaOnPress
import ua.ilyadreamix.ddz.theme.DDZGreen
import ua.ilyadreamix.ddz.theme.DDZRed
import ua.ilyadreamix.ddz.theme.DDZYellow

private val grades = listOf(
    GradeInfo(1, DDZGreen),
    GradeInfo(2, DDZGreen),
    GradeInfo(3, DDZGreen),
    GradeInfo(4, DDZGreen),
    GradeInfo(5, DDZYellow),
    GradeInfo(6, DDZYellow),
    GradeInfo(7, DDZYellow),
    GradeInfo(8, DDZYellow),
    GradeInfo(9, DDZYellow),
    GradeInfo(10, DDZRed),
    GradeInfo(11, DDZRed)
)

@Composable
fun GradesList(
    modifier: Modifier = Modifier,
    onGradeItemClick: (GradeInfo) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(DDZDimen.ScreenSidesPadding),
        contentPadding = WindowInsets.navigationBars.asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(DDZDimen.GridSpacing)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.select_grade),
                style = MaterialTheme.typography.h4
            )
        }

        items(
            items = grades,
            key = { it.grade }
        ) { gradeInfo ->
            GradeItem(gradeInfo, onClick = onGradeItemClick)
        }
    }
}

@Composable
fun GradeItem(
    gradeInfo: GradeInfo,
    modifier: Modifier = Modifier,
    onClick: (GradeInfo) -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(DDZDimen.GradeItemHeight)
            .changeAlphaOnPress(
                onClick = {
                    onClick(gradeInfo)
                }
            ),
        backgroundColor = gradeInfo.color,
        shape = RoundedCornerShape(DDZDimen.GradeItemCorners)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = DDZDimen.GradeItemPadding,
                    start = DDZDimen.GradeItemPadding * 2,
                    end = DDZDimen.GradeItemPadding * 2,
                    bottom = DDZDimen.GradeItemPadding
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.grade_f, gradeInfo.grade),
                style = MaterialTheme.typography.body1
            )
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(DDZDimen.SmallButtonSize)
            )
        }
    }
}

data class GradeInfo(
    val grade: Int,
    val color: Color
)
