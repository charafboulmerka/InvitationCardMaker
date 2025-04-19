package com.jeddah.invitationcards.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.jeddah.invitationcards.R

class UserCreate : AppIntro()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_user_create)

        isColorTransitionsEnabled = true

        addSlide(
            AppIntroFragment.createInstance(
            title = "مرحبا بك",
            description = "شوف نشرح لك كيف يمكنك كسب المال عن طريق إنجاز تصميم و عرضه للبيع في خطوات بسطية",
            imageDrawable = R.drawable.intro1,
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.white,
            backgroundColorRes = R.color.Baby_Blue,
            titleTypefaceFontRes = R.font.jannafont,
            descriptionTypefaceFontRes = R.font.jannafont,
        ))

        addSlide(AppIntroFragment.createInstance(
            title = "الخطوة الأولى",
            description = "في هذه الخطوة يجب عليك انجاز الخلفية فقط او إضافة خلفية تملكها مسبقا و إضغط على زر حفظ للإنتقال للخطوة الثانية",
            imageDrawable = R.drawable.intro2,
            backgroundDrawable = R.drawable.anniversary_card_10_back,
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.white,
            backgroundColorRes = R.color.Mauve,
            titleTypefaceFontRes = R.font.jannafont,
            descriptionTypefaceFontRes = R.font.jannafont,
        ))

        addSlide(AppIntroFragment.createInstance(
            title = "الخطوة الثانية",
            description = "هنا يجب عليك إكمال بقية التصميم التصميم و حفظه كله دفعة واحدة",
            imageDrawable = R.drawable.intro3,
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.white,
            backgroundColorRes = R.color.Basket_Ball_Orange,
            titleTypefaceFontRes = R.font.jannafont,
            descriptionTypefaceFontRes = R.font.jannafont,
        ))

        addSlide(AppIntroFragment.createInstance(
            title = "الخطوة الثالثة",
            description = "إعطاء اسم للتصميم و سعر مناسب و إضغط على إضافة",
            imageDrawable = R.drawable.intro4,
            titleColorRes = R.color.black,
            descriptionColorRes = R.color.white,
            backgroundColorRes = R.color.BurlyWood,
            titleTypefaceFontRes = R.font.jannafont,
            descriptionTypefaceFontRes = R.font.jannafont,
        ))

        isWizardMode = true
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"

    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        startActivity(Intent(this,UserSelectDesign::class.java))
        finish()
    }
}