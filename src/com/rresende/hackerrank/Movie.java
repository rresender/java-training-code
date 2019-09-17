package com.rresende.hackerrank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class Movie {
	
    private final int movieId;
    private final float rating;
    private List<Movie> similarMovies; // Similarity is bidirectional
 
    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        similarMovies = new ArrayList<Movie>();
    }
 
    public int getId() {
        return movieId;
    }
 
    public float getRating() {
        return rating;
    }
 
    public void addSimilarMovie(Movie movie) {
        similarMovies.add(movie);
        movie.similarMovies.add(this);
    }
 
    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }
   
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", rating=" + rating + "]";
	}

	/*
     * Implement a function to return top rated movies in the network of movies 
     * reachable from the current movie
     * eg:             A(Rating 1.2)
     *               /   \
     *            B(2.4)  C(3.6)
     *              \     /
     *                D(4.8)
     * In the above example edges represent similarity and the number is rating.
     * getMovieRecommendations(A,2) should return C and D (sorting order doesn't matter so it can also return D and C)
     * getMovieRecommendations(A,4) should return A, B, C, D (it can also return these in any order eg: B,C,D,A)
     * getMovieRecommendations(A,1) should return D. Note distance from A to D doesn't matter, return the highest rated.
     *     
     *     @param movie
     *     @param numTopRatedSimilarMovies 
     *                      number of movies we want to return
     *     @return List of top rated similar movies
     *     
     *     RUNTIME: O(n log n) + O(n)
     *     SPATIAL: O(n)
     */
    public static Set<Movie> getMovieRecommendations(Movie movie, int N) {
    	
    	if (movie == null) {
    		throw new IllegalArgumentException("The Movie cannot be null or empty!");
    	}
    	
    	final List<Movie> similarMovies = movie.getSimilarMovies();
        	
    	if (similarMovies.isEmpty()) {
			return new HashSet<>();
    	}
    	
    	final List<Movie> movies = new ArrayList<Movie>();
    
    	navigate(movie, movies);
    	
//    	O(n log n) 
    	Collections.sort(movies, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return  Float.valueOf(o1.getRating()).compareTo(Float.valueOf(o2.getRating()));
			}
		});
    	
    	if (N > movies.size()) {
    		return new HashSet<>(movies);
    	}
     	
        return new HashSet<>(movies.subList(movies.size() - N, movies.size()));
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieId != other.movieId)
			return false;
		return true;
	}

	private static void navigate(Movie movie, List<Movie> result) {
    	List<Movie> similarMovies = movie.getSimilarMovies();
    	
    	if (similarMovies.isEmpty()) {
    		result.add(movie);
    		return;
    	}
    	//O(n)
    	for (Movie m : similarMovies) {
    		if(!result.contains(m)) {
    			result.add(m);
    			navigate(m, result);
    		} 
		}
    }
    
    public static void main(String[] args) {
		
//    	 * eg:             A(Rating 1.2)
//         *               /   \
//         *            B(2.4)  C(3.6)
//         *              \     /
//         *                D(4.8)
    	
    	Movie m1 = new Movie(1, 1.2f);
    	Movie m2 = new Movie(2, 3.6f);
    	Movie m3 = new Movie(3, 2.4f);
    	Movie m4 = new Movie(4, 4.8f);
    	
    	m1.addSimilarMovie(m2);
    	m1.addSimilarMovie(m3);
    	
    	m2.addSimilarMovie(m4);
    	m3.addSimilarMovie(m4);
    	
    	Set<Movie> list1 = getMovieRecommendations(m1, 3);
    	for (Movie movie : list1) {
    		System.out.println(movie);
		}
    
//    	Set<Movie> list2 = getMovieRecommendations(m1, 4);
//    	for (Movie movie : list2) {
//    		System.out.println(movie);
//		}
//    	
//    	Set<Movie> list3 = getMovieRecommendations(m1, 1);
//    	for (Movie movie : list3) {
//    		System.out.println(movie);
//		}
    	
	}
   
}