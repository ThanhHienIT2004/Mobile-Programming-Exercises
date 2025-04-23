package com.example.baitaplaptrinhdidong.screens.week5.w5_1

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaplaptrinhdidong.R
import com.example.baitaplaptrinhdidong.ui.theme.DarkPurple
import com.example.baitaplaptrinhdidong.ui.theme.LightBlue
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun W5_1(navController: NavController) {
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()
    val webClientId = context.getString(R.string.default_web_client_id)

    // Khởi tạo GoogleSignInManager
    val signInManager = remember { GoogleSignInManager(context, auth, webClientId) }

    // Launcher để xử lý kết quả đăng nhập
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        signInManager.handleSignInResult(
            result,
            onSuccess = {
                navController.navigate("w5_1_profile")
            },
            onFailure = { error ->
                Log.e("GoogleSignIn", "Sign-in failed: $error")
            }
        )
    }

    // UI
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(LightBlue),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_uth),
                contentDescription = "UTH Smart Tasks",
                modifier = Modifier.size(200.dp, 100.dp)
            )
        }

        Text(
            text = "Smart Tasks",
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
            ),
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = "A simple and efficient to-do app",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                color = Color(0xFF2196F3),
            ),
            modifier = Modifier.padding(bottom = 100.dp)
        )

        Text(
            text = "Welcome",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "Ready to explore? Log in to get started.",
            style = TextStyle(
                fontSize = 14.sp
            ),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Button(
            onClick = {
                launcher.launch(signInManager.getSignInIntent())
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue,
                contentColor = DarkPurple
            ),
            shape = RoundedCornerShape(6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_gg),
                contentDescription = "Icon google",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = " SIGN IN WITH GOOGLE",
                fontWeight = FontWeight.Bold
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "© UTHSmartTasks",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }
}

class GoogleSignInManager(
    private val context: Context,
    private val auth: FirebaseAuth,
    private val webClientId: String
) {
    private val googleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(webClientId)
            .requestEmail()
            .build()
        GoogleSignIn.getClient(context, gso)
    }

    // Lấy intent để khởi chạy đăng nhập
    fun getSignInIntent(): Intent = googleSignInClient.signInIntent

    // Xử lý kết quả đăng nhập
    fun handleSignInResult(result: ActivityResult, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            onSuccess() // Gọi callback khi đăng nhập thành công

            //Hien thong bao neu can
         val account = task.getResult(Exception::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(
                            context,
                            "Đăng nhập thành công: ${user?.displayName}",
                            Toast.LENGTH_LONG
                        ).show()
                        onSuccess() // Gọi callback khi đăng nhập thành công
                    } else {
                        val errorMessage = task.exception?.message ?: "Lỗi không xác định"
                        Toast.makeText(
                            context,
                            "Đăng nhập thất bại: $errorMessage",
                            Toast.LENGTH_LONG
                        ).show()
                        onFailure(errorMessage)
                    }
                }

        } catch (e: Exception) {
            val errorMessage = e.message ?: "Lỗi không xác định"
            Toast.makeText(context, "Lỗi: $errorMessage", Toast.LENGTH_LONG).show()
            onFailure(errorMessage)
        }
    }
}