package com.arlina.android_laba10_11_kuzvah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.arlina.android_laba10_11_kuzvah.data.students
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.arlina.android_laba10_11_kuzvah.data.Student
import com.arlina.android_laba10_11_kuzvah.data.students
import com.arlina.android_laba10_11_kuzvah.ui.theme.Android_laba1011_KuzvahTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_laba1011_KuzvahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ){
                    StudentApp()
                }
            }
        }
    }
}

@Composable
fun StudentIcon(
    @DrawableRes studentIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(studentIcon),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)

    )
}
@Composable
fun StudentInformation(
    @StringRes studentName: Int,
    studentAge: Int,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier){
        Text(
            text = stringResource(studentName),
            modifier = Modifier.padding(top = dimensionResource
                (R.dimen.padding_small)),
                style = MaterialTheme.typography.displayMedium
            )

        Text(
            text = stringResource(R.string.years_old,studentAge),
            style = MaterialTheme.typography.bodyLarge
            )


    }
}

@Composable
fun StudentItem(
    student: Student,
    modifier: Modifier = Modifier
){Card(modifier = modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
    ){
    StudentIcon(student.imageResouceId)
        StudentInformation(student.name, student.age)
    }}
}

@Composable
fun StudentApp() {
    Scaffold { it ->
        LazyColumn(contentPadding = it) {
            items(students) {
                StudentItem(
                    student = it,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Preview
@Composable
fun StudentPreview(){
    Android_laba1011_KuzvahTheme(darkTheme = false){
        StudentApp()
    }
}

@Preview
@Composable
fun StudentDarkThemePreview(){
    Android_laba1011_KuzvahTheme(darkTheme = true) {
        StudentApp()
    }
}
