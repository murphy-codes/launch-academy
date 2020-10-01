package com.launchacademy.marathon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {
  @Id
  @SequenceGenerator(name="song_generator", sequenceName="songs_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="song_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank(message = "Title cannot be blank")
  @Size(min = 1, max = 35, message = "Titles cannot be fewer than 1 or more than 35 characters")
  @Column(name="title", nullable=false)
  private String title;

  @NotBlank(message = "Genre cannot be blank")
  @Size(min = 1, max = 16, message = "Genre cannot be fewer than 1 or more than 16 characters")
  @Pattern(regexp = "^([^0-9]*)$", message = "Genres cannot contain numbers")
  @Column(name="genre", nullable=false)
  private String genre;

  @NotNull
  @Min(value = 1000, message = "Release year must be after 999")
  @Max(value = 2020, message = "Release year must be before 2020")
  @Column(name="release_year", nullable=false)
  private Integer releaseYear;

  @NotNull(message = "Please designate whether or not this track contains explicit content")
  @Column(name="explicit_content", nullable=false)
  private Boolean explicitContent;
}
