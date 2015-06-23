package cs1c;
public class SongsInGenre
{

    private String genreName;
    private int num;
    
    public SongsInGenre(String gnrName, int count)
    {
        this.genreName = gnrName;
        this.num = count;
    }
    
    public String getGenreName()
    {
        return genreName;
    }
    
    public int getCounter()
    {
        return num;
    }
}
