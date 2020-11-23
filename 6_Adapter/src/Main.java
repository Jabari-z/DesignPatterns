//适配器 通过使用适配器模式，我们可以统一两个不兼容的接口。
interface Player {
    public void play(String type, String fileName);
}
// 需要适配的  AudioPlayer
interface AudioPlayer {
    public void playAudio(String fileName);
}
// 需要适配的  VideoPlayer
interface VideoPlayer {
    public void playVideo(String fileName);
}
class MyAudioPlayer implements AudioPlayer {
    @Override
    public void playAudio(String fileName) {
        System.out.println("Playing. Name: "+ fileName);
    }
}
class MyVideoPlayer implements VideoPlayer {
    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing. Name: "+ fileName);
    }
}

//适配器
class MyPlayer implements Player {

//    需要适配的两个player
    AudioPlayer audioPlayer = new MyAudioPlayer();
    VideoPlayer videoPlayer = new MyVideoPlayer();

    public MyPlayer(){
    }
//    重写play方法 根据接口 play
    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("avi")){
            videoPlayer.playVideo(fileName);
        }else if(audioType.equalsIgnoreCase("mp3")){
            audioPlayer.playAudio(fileName);
        }
    }
}
public class Main{
    public static void main(String[] args) {
        MyPlayer myPlayer = new MyPlayer();

        myPlayer.play("mp3", "h.mp3");
        myPlayer.play("avi", "me.avi");
    }
}