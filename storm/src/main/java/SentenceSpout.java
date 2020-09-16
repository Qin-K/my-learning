import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;

/**
 * @author qinkai
 * @date 2020-07-13 15:09:02
 **/
public class SentenceSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;

    private String[] sentences = {
            "my name is soul",
            "im a boy",
            "i have a dog",
            "my dog has fleas",
            "my girl friend is beautiful"
    };

    private int index = 0;

    @Override
    public void open(Map<String, Object> conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void nextTuple() {
        if (index < sentences.length) {
            collector.emit(new Values(sentences[index]));
            index++;
        }
        Utils.sleep(1);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("sentence"));
    }
}
