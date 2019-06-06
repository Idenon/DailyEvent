# DailyEvent
「ある日時をしきい値として、前回実行時からそれを超えたかどうか」を判定するクラスを作った

# How to Use / 使い方
## How to Import / 導入方法
gradle による配布などは現状ありません。

DailyEvent/app/src/main/java/jp/idenon/dailyevent/DailyEventController.kt の DailyEventController クラスを Copy/Paste して使ってください。

反響が大きいようであれば gradle による配布対応を検討します。

## How to Use on on development your application. / このクラスの使い方
デイリーを判定したいイベント１つにつき、このクラスを１つインスタンス化します。

この時、引数としてしきい値にしたい時と分を Int で渡します。

例） しきい値を 5 時 10 分としたい場合

`val event = DailyEventController(5, 10)`

そのイベントが実行された時、execute() メソッドを呼びます。

そうすると、このインスタンスの中で実行時間が保存されます。

例）

`event.execute()`

「デイリー範囲内で実行済みかどうか」を知りたい時、isDoneDaily() メソッドを呼びます。

実行済みなら `true` 未実行なら `false` を返します。

例）

`if (event.isDoneDaily()) { 【実行済みの時に行う処理をここに書く】 }`



 ## あとは大量に作ってリスト管理するなり、あなたの作ったクラスにメンバとして持たせるなりお好きにどうぞ。

