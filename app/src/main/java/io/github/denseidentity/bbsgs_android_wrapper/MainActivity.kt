package io.github.denseidentity.bbsgs_android_wrapper

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.github.denseidentity.bbsgroupsig.BBSGS

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("BBSGS", "Hello BBSGS")

        val msg: String = "hello"
        Log.d("BBSGS", "Message: $msg")

        // test native wrapper
        BBSGS.bbs04InitPairing()
        val (gpk, osk, isk) = BBSGS.bbs04Setup()
        val usk = BBSGS.bbs04UserKeygen(gpk, isk)
        val sig = BBSGS.bbs04Sign(gpk, usk, msg.toByteArray())
        val ok = BBSGS.bbs04Verify(gpk, sig, msg.toByteArray())
        Log.d("BBSGS", "Signature valid on $msg? $ok")
        val msg2: String = "world"
        val ok2 = BBSGS.bbs04Verify(gpk, sig, msg2.toByteArray())
        Log.d("BBSGS", "Signature valid on $msg2? $ok2")
    }
}
