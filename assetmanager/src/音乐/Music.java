package 音乐;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
//这是一个简单的音乐类
//只是 音乐打开，和关闭
public class Music {
	AudioStream as;
	public Music() {
		
	}
    //打开音乐
	public void begin()
	{

		FileInputStream fileau = null;
			try {
				fileau = new FileInputStream("music" + File.separator+"lzlh.wav");


				}
			catch (FileNotFoundException ex) {
			}

			try {as = new AudioStream(fileau);
			AudioPlayer.player.start(as);
		
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}

    }
	//关闭音乐
	public void stop()
	{
		AudioPlayer.player.stop(as);
	
	}
	
}
