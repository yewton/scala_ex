# インポートのいろいろ
## 単純名指定
```java
import Fruits.{x}
```

* `import Fruits.x` は `import Fruits.{x}` の特殊系
* `import Fruits._` は `import Fruits.{_}` の特殊系

## 名称変更
```java
import java.sql.{Date => SDate}
```

* 別パッケージの同名クラスがあるときなど

## 隠蔽と catch-all
```java
import Fruits.{Apple => _, _}
```

* 隠蔽節で指定されたメンバを除く全てをインポート
* 隠蔽節単体で使うことあるのか？

# 暗黙のインポート
```java
import java.lang._ // java.lang パッケージのすべて
import scala._     // scala パッケージのすべて
import Predef._    // Predef パッケージのすべて
```

* `java.lang.Thread` でなく `Thread` と書ける
* `scala.List` でなく `List` と書ける
* `Predef.assert` でなく `assert` と書ける
* この 3 つだけは、後からインポートされたものが先にインポートされたものを隠す
  * `StringBuilder` で参照されるのは `java.lang.StringBuilder` *ではなく* `scala.StringBuilder`
