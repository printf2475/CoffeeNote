package com.edc.coffeenote.core.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.os.Build

fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("no activity")
}

fun Context.openWeb(url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }
}

fun Context.getVersionName(): String = packageManager.getPackageInfo(packageName, 0).versionName

/**
 * 메일 전송.
 * @param recipients 메일 수신 리스트.
 * @param subject 메일 주제.
 * @param text 메일 기본 내용.
 */
fun Context.intentMail(
    recipients: Array<String>,
    subject: String,
    text: String,
    chooserTitle: String
) {
    val sendIntent = Intent(Intent.ACTION_SENDTO).apply {
        setData(Uri.parse("mailto:"))
        putExtra(Intent.EXTRA_EMAIL, recipients)
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, text)
    }
    val chooserIntent = Intent.createChooser(sendIntent, chooserTitle).apply {
        flags += Intent.FLAG_ACTIVITY_NEW_TASK
    }
    this.startActivity(chooserIntent)
}