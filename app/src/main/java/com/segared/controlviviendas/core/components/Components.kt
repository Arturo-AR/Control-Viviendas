package com.segared.controlviviendas.core.components

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.segared.controlviviendas.R
import com.segared.controlviviendas.core.util.getRoute
import com.segared.controlviviendas.ui.theme.primary
import com.segared.controlviviendas.ui.theme.primary_dark
import com.segared.controlviviendas.ui.theme.primary_light
import com.segared.controlviviendas.ui.theme.secondary_text

@Composable
fun MainLogo(
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.logo_segared),
        contentDescription = null
    )
}

@Composable
fun MainScaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    titleScreen: String,
    inDashboard: Boolean = false,
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    onTopBarIconAction: () -> Unit,
    bottomBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = drawerContent,
        topBar = {
            MainTopBar(
                title = titleScreen,
                inDashboard = inDashboard
            ) {
                onTopBarIconAction()
            }
        },
        bottomBar = bottomBar,
        floatingActionButton = floatingActionButton,
        backgroundColor = primary,
        content = content
    )
}

@Composable
fun MainTopBar(
    title: String,
    inDashboard: Boolean,
    onBackArrowClicked: () -> Unit
) {
    TopAppBar(
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = if (inDashboard) Icons.Default.Menu else Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        onBackArrowClicked()
                    }
                )
                Text(text = title, color = Color.White)
                MainLogo(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(8.dp)
                )
            }
        },
        modifier = Modifier.height(70.dp),
        backgroundColor = primary_dark,
        elevation = 0.dp
    )
}

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: String,
    labelId: String,
    enable: Boolean = true,
    isSingleLine: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    onTextChange: (String) -> Unit
) {
    TextField(
        value = valueState,
        onValueChange = { onTextChange(it) },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enable,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            unfocusedLabelColor = Color.Black
        )
    )
}

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    passwordState: String,
    label: String,
    enable: Boolean = true,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default,
    onTextChange: (String) -> Unit
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    TextField(
        value = passwordState,
        onValueChange = {
            onTextChange(it)
        },
        label = { Text(text = label) },
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp, color = MaterialTheme.colors.onBackground),
        modifier = modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        enabled = enable,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "show password")
            }
        },
        keyboardActions = onAction,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            textColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            unfocusedLabelColor = Color.Black
        ),
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    loginEnable: Boolean,
    onButtonSelected: () -> Unit
) {
    Button(
        onClick = { onButtonSelected() },
        enabled = loginEnable,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = primary_dark,
            disabledBackgroundColor = primary_light,
            contentColor = Color.White,
            disabledContentColor = secondary_text,
        )
    ) {
        Text(text = stringResource(id = R.string.login))
    }
}

@Composable
fun MainMenuList(
    navController: NavController,
    items: List<String>,
    onClick: () -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(items.size) { index ->
                Card(
                    backgroundColor = Color.Black,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .clickable {
                            try {
                                navController.navigate(items[index].getRoute())
                            } catch (ex: Exception) {
                                onClick()
                            }
                        },
                    elevation = 8.dp,
                ) {
                    Text(
                        text = items[index],
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    )
}

@Composable
fun ShowAlertDialog(
    title: String,
    message: @Composable () -> Unit,
    positiveButtonText: String = "Aceptar",
    negativeButtonText: String = "Cancelar",
    openDialog: MutableState<Boolean>,
    onYesPress: () -> Unit
) {
    if (openDialog.value) {
        AlertDialog(onDismissRequest = { openDialog.value = false },
            title = {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = message,
            backgroundColor = primary,
            shape = MaterialTheme.shapes.small,
            buttons = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = { openDialog.value = false }) {
                        Text(text = negativeButtonText, color = Color.White, fontSize = 16.sp)
                    }
                    TextButton(onClick = { onYesPress.invoke() }) {
                        Text(text = positiveButtonText, color = Color.White, fontSize = 16.sp)
                    }
                }
            })
    }
}

@Composable
fun GetImage(
    onReturn: (Bitmap?) -> Unit
) {
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        var currentBitmap: Bitmap? = null
        if (Build.VERSION.SDK_INT < 28) {
            currentBitmap = MediaStore.Images
                .Media.getBitmap(context.contentResolver, uri)
        } else {
            val source = uri?.let { it1 ->
                ImageDecoder
                    .createSource(context.contentResolver, it1)
            }
            source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
                ?.let { it2 -> currentBitmap = it2 }
        }
        bitmap.value = currentBitmap
    }

    Row(modifier = Modifier.padding(start = 8.dp)) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black
            ),
            onClick = {
                launcher.launch("image/*")
            }) {
            Text(
                color = Color.White,
                text = "Agregar Credencial"
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        bitmap.value?.let { btm ->
            onReturn(btm)
            Image(
                bitmap = btm.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

@Composable
fun DropDownMenu(
    list: List<String>,
    onItemSelected: (Int) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {
                selectedItem = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = {
                Text(text = "Tipo de Mascota")
            },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.clickable { expanded = !expanded })
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textFieldSize.width.toDp() })
        ) {

            list.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedItem = label
                    expanded = false
                    val idType = when (label) {
                        "Perro" -> 1
                        "Gato" -> 2
                        else -> 0
                    }
                    onItemSelected(idType)
                }) {
                    Text(text = label)
                }
            }

        }

    }
}