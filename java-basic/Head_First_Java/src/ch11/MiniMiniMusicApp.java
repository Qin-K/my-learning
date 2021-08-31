package ch11;
import javax.sound.midi.*;
public class MiniMiniMusicApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}
	public void play() {
		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 20, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);
			
			player.setSequence(seq);
			
			player.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
