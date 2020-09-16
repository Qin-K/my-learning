import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词计数器
 *
 * @author qinkai
 * @date 2020-07-13 15:24:43
 **/
public class WordCountBolt extends BaseRichBolt {

    private OutputCollector collector;

    /**
     * 存储单词和对应的计数
     */
    private HashMap<String, Long> counts = null;

    @Override
    public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
        this.counts = new HashMap<>(16);
    }

    @Override
    public void execute(Tuple input) {
        String word = input.getStringByField("word");
        long count = counts.getOrDefault(word, 0L) + 1;
        counts.put(word, count);
        collector.emit(new Values(word, count));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word", "count"));
    }
}
