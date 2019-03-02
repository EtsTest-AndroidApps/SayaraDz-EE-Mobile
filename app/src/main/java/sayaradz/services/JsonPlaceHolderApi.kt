package sayaradz.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header


interface JsonPlaceHolderApi {

// Getting all the brands
    @GET("marque")  // relative url ..  gonna change name of tha table
    fun getMarques(@Header("Authorization") token : String): Call<List<Marque>>


// Getting all the models
    @GET("modele")
    fun getModels(@Header("Authorization") token : String): Call<List<Model>>


// I'll be workin on requests with parametres ( like havin models for a marque )

}
