# チェックワーク 〜クラスを理解しよう！〜

## ⚠️ポイント⚠️
- クラスとは何か，インスタンスとは何か
- クラスの定義の仕方
- クラスのインスタンス化の仕方
- クラスのプロパティやメソッドの使い方
- data classはデータをまとめて扱える

## 💡クラスとは何か，インスタンスとは何か
- クラス：設計図
- インスタンス：実体

実際のコードでは，作成したクラスのインスタンスを作成するよ！
今回はUserクラスを作成したね．

## 💡クラスの定義の仕方
変数を定義するときは`var`や`val`，関数（メソッド）を定義するときは`fun`と宣言するように，クラスを定義するときは`class`と宣言するよ！
今回はname, course, commentという値を持つUserクラスを作成したね．
これらの値を**プロパティ**と呼ぶよ．
```
data class User(
    val name: String,
    val course: String,
    val comment: String,
)
```

今回はUserクラスに**メソッド**は定義しなかったけど，以下のようにメソッドを定義することもできるよ！
```
class User(val name: String) {
    // 自分の名前を出力
    fun greet() {
        println(this.name)
    }
}
```

## 💡クラスのインスタンス化の仕方
クラスをもとに実際の値（インスタンス）を作成することをインスタンス化というよ！
インスタンスを作成するときは，クラスを定義するときに決めた値を引数に渡す必要があるよ．
```
val user = User("Doggy", "Android", "Check work is fun!")
```

このとき作成したインスタンスの型ははUser型だよ．
実は，`1`のような整数はInt型のインスタンスで，`"あいうえお"`のString型のインスタンスなんだ．
Int型やString型は元々用意されている型だよ．
User型は元々存在する型ではないから，今回はUser型を自分で作ったということになるね！
今回のように，必要な型はその都度作成することができるよ．

## 💡クラスのプロパティやメソッドの使い方
作成したインスタンスのプロパティを使用するときは「.（ピリオド）」を使うよ！
今回はUserクラスのインスタンスのnameにアクセスするために以下のようなコードを書いたね！
```
// userのnameプロパティにアクセスする．
user.name
```

クラスに定義したメソッドを使用するときもピリオドを使うよ！
```
// Userクラスに定義されたgreet()メソッドを実行する．
user.greet()
```

普段使っている`toString()`などもクラスに定義されたメソッドだよ．
例えば以下のようなコードでは，Int型に定義された`toString()`を使用しているね！

```
// Int型の12345をString型の"12345"に変換する．
12345.toString()
```

## 💡data classはデータをまとめて扱える
今回作成したようなクラスはdata classというよ．
data classはデータをまとめて扱うときに使うクラスだよ．
例えば，データベースに値をまとめて保存するために，保存する値をまとめたdata classを作成したりするよ！
data classを定義するときは，`class`の前に`data`と書く必要があるよ．
だから今回作成したUserクラスには`data`という文字を付けていたんだね！


