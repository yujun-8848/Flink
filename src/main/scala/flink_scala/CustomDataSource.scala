package flink_scala

import org.apache.flink.streaming.api.functions.source.SourceFunction

class CustomDataSource extends SourceFunction[Long] {

  var count: Long = 0L
  var isRunning: Boolean = true

  override def run(ctx: SourceFunction.SourceContext[Long]): Unit = {
    while (isRunning && count < 100) {
      ctx.collect(count)
      count += 1
      Thread.sleep(1000)
    }

  }

  override def cancel(): Unit = {
    isRunning = false
  }
}
