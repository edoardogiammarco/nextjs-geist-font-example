package com.example.movieshowcase.validator;

import com.example.movieshowcase.Movie;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MovieValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Movie.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Movie movie = (Movie) target;

        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            errors.rejectValue("title", "title.empty", "Title must not be empty");
        }

        if (movie.getReleaseYear() < 1888) { // The year of the first film ever made
            errors.rejectValue("releaseYear", "releaseYear.invalid", "Release year is invalid");
        }

        // Add more validations as needed
    }
}
