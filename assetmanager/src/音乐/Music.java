package ����;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
//����һ���򵥵�������
//ֻ�� ���ִ򿪣��͹ر�
public class Music {
	AudioStream as;
	public Music() {
		
	}
    //������
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
	//�ر�����
	public void stop()
	{
		AudioPlayer.player.stop(as);
	
	}
	
}
