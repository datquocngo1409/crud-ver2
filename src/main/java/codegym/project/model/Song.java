package codegym.project.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    private String description;

    @NotEmpty
    private String singer_name;

    private String mp3_link;

    private String img_link;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private SongCategory songCategory;

    public Song() {
    }

    public Song(@NotEmpty String name, String description, @NotEmpty String singer_name, String mp3_link, String img_link, SongCategory songCategory) {
        this.name = name;
        this.description = description;
        this.singer_name = singer_name;
        this.mp3_link = mp3_link;
        this.img_link = img_link;
        this.songCategory = songCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMp3_link() {
        return mp3_link;
    }

    public void setMp3_link(String mp3_link) {
        this.mp3_link = mp3_link;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public SongCategory getSongCategory() {
        return songCategory;
    }

    public void setSongCategory(SongCategory songCategory) {
        this.songCategory = songCategory;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }
}
