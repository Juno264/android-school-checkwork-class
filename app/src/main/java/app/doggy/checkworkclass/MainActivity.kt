package app.doggy.checkworkclass

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.doggy.checkworkclass.databinding.ActivityMainBinding
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json



class MainActivity : AppCompatActivity() {

    // バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }



        // SharedPreferencesのインスタンスを取得
        val sharedPref: SharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

        // 保存した内容を表示する．
        binding.nameText.text = sharedPref.getString(NAME, "名前")
        binding.courseText.text = sharedPref.getString(COURSE, "コース")
        binding.commentText.text = sharedPref.getString(COMMENT, "チェックワーク最高！")

        // save_buttonを押したときの処理
        binding.saveButton.setOnClickListener {

            // SharedPreferences.Editorを取得する．
            val editor = sharedPref.edit()

            // Step1：EditTextに入力した値をEditorに渡す．
            val nameText = binding.nameEditText.text.toString()
            val courseText = binding.courseEditText.text.toString()
            val commentText = binding.commentEditText.text.toString()

            val defaultUser = User(nameText,courseText,commentText)

            editor.putString(USER, Json.encodeToString(defaultUser))
            editor.apply()
//            editor.commit()

            val userString = sharedPref.getString(USER, Json.encodeToString(defaultUser))
            val user = if (userString != null) Json.decodeFromString(userString) else defaultUser

            binding.nameText.text = user.name
            binding.courseText.text = user.course
            binding.commentText.text = user.comment

            // 渡した値を保存する．
            Log.d(USER, user.toString())
            Log.d(USER, Json.encodeToString(user))
        }
    }

    companion object {
        // データを保存するときに用いるKey
        private const val NAME = "name"
        private const val COURSE = "course"
        private const val COMMENT = "comment"
        private const val USER = "user"
    }
}