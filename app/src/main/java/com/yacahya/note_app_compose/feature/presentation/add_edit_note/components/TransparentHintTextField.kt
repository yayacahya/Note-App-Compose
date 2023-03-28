package com.yacahya.note_app_compose.feature.presentation.add_edit_note.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.yacahya.note_app_compose.common.util.TestTags

@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    testTag: String = ""
) {
    Box(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .testTag(testTag)
                .fillMaxWidth(),
            label = { Text(hint) }
        )
    }
}

@Preview
@Composable
fun TransparentHintTextFieldPreview() {
    TransparentHintTextField(
        text = "test title",
        hint = "Title",
        onValueChange = {},
        singleLine = true,
        textStyle = MaterialTheme.typography.body1,
        testTag = TestTags.TITLE_TEXT_FIELD
    )
}