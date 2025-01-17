package sayaradz.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sayaradz.dataClasses.*

class Api {
    companion object {
        val api: ServiceProvider by lazy {
            ServiceBuilder.buildService(ServiceProvider::class.java)
        }


        fun getMarques(TAG: String, idToken: String): MutableLiveData<ArrayList<Marque>> {


            val call = api.getAllMarques(idToken) // The request included the token
            var marqueRespond: List<Marque>?
            var marqueList = ArrayList<Marque>()
            var finalList = MutableLiveData<ArrayList<Marque>>()

            call.enqueue(object : Callback<List<Marque>> {
                override fun onResponse(call: Call<List<Marque>>, response: Response<List<Marque>>) {
                    Log.i(TAG, "DisplayMarqueList: call enqueue")

                    if (!response.isSuccessful) {
                        Log.i(TAG, "CODE:" + response.code().toString())
                        return
                    }

                    marqueRespond = response.body()  // Getting the list
                    if (marqueRespond != null) {
                        Log.i(TAG, "REPONSES: HERE is ALL THE BRANDS:")
                        for (m in marqueRespond!!) {
                            var content = ""
                            content += " $m \n"
                            Log.i(TAG, "\n=========\n$content")
                            marqueList.add(m)
                        }
                        marqueList.sortBy { it.name }
                        finalList.value = marqueList
                        //Log.i("TAG",marqueList.toString())
                    }
                }

                override fun onFailure(call: Call<List<Marque>>, t: Throwable) {
                    Log.i(TAG, "error CODE:" + t.message)
                }
            })
            return finalList
        }


        fun getModels(TAG: String, idToken: String, marqueId: String): MutableLiveData<ArrayList<Modele>> {

            val call = api.getModelsByMarque(idToken, marqueId) // The request included the token
            var modeleRespond: List<Modele>?
            var modelList = ArrayList<Modele>()
            var finalList = MutableLiveData<ArrayList<Modele>>()

            call.enqueue(object : Callback<List<Modele>> {
                override fun onResponse(call: Call<List<Modele>>, response: Response<List<Modele>>) {
                    Log.i(TAG, "DisplayModelList: call enqueue")

                    if (!response.isSuccessful()) {
                        Log.i(TAG, "CODE:" + response.code().toString())
                        return
                    }


                    modeleRespond = response.body()  // Getting the list
                    if (modeleRespond != null) {
                        Log.i(TAG, "REPONSES: HERE is ALL THE MODELS OF $marqueId MARQUE:")
                        for (m in modeleRespond!!) {
                            var content = ""
                            content += "$m + \n"

                            Log.i(TAG, "\n=========\n$content")
                            modelList.add(m)
                        }
                        modelList.sortBy { it.name }
                        finalList.value = modelList
                        //Log.i("TAG",marqueList.toString())
                    }
                }

                override fun onFailure(call: Call<List<Modele>>, t: Throwable) {
                    Log.i(TAG, "error CODE:" + t.message)
                }
            })
            return finalList
        }


        fun getVersions(TAG: String, idToken: String, modeleId: String): MutableLiveData<ArrayList<Version>> {

            val call = api.getVersionsByModele(idToken, modeleId) // The request included the token
            var versioneRespond: List<Version>?
            var versionList = ArrayList<Version>()
            var finalList = MutableLiveData<ArrayList<Version>>()

            call.enqueue(object : Callback<List<Version>> {
                override fun onResponse(call: Call<List<Version>>, response: Response<List<Version>>) {
                    Log.i(TAG, "DisplayVersionList: call enqueue")

                    if (!response.isSuccessful) {
                        Log.i(TAG, "CODE:" + response.code().toString())
                        return
                    }

                    versioneRespond = response.body()  // Getting the list
                    if (versioneRespond != null) {
                        Log.i(TAG, "REPONSES: HERE is ALL THE VERSIONS OF $modeleId MARQUE:")
                        for (m in versioneRespond!!) {
                            var content = ""
                            content += " $m \n"
                            Log.i(TAG, "\n=========\n$content")
                            versionList.add(m)
                        }
                        versionList.sortBy { v-> v.name }
                        finalList.value = versionList
                        //Log.i("TAG",marqueList.toString())
                    }
                }

                override fun onFailure(call: Call<List<Version>>, t: Throwable) {
                    Log.i(TAG, "error CODE:" + t.message)
                }
            })
            return finalList
        }


        fun getFichTech(TAG: String, idToken: String, fichTechID: String): MutableLiveData<FichTech?> {

            val call = api.getFichTechByVersion(idToken, fichTechID) // The request included the token
            var fichTech: FichTech?
            val toReturn = MutableLiveData<FichTech?>()

            call.enqueue(object : Callback<FichTech> {
                override fun onResponse(call: Call<FichTech>, response: Response<FichTech>) {
                    Log.i(TAG, "Display FichTech: call enqueue")

                    if (!response.isSuccessful) {
                        Log.i(TAG, "CODE:" + response.code().toString())
                        return
                    }

                    fichTech = response.body()

                    if (response != null) {
                        var content = ""
                        content +=  fichTech?.toString() + "\n"
                        Log.i(TAG, "\n=========\n$content")
                        toReturn.value = fichTech

                    }
                }

                override fun onFailure(call: Call<FichTech>, t: Throwable) {
                    Log.i(TAG, "error CODE:" + t.message)
                }
            })
            return toReturn
        }


        fun getVersionDetails(TAG: String, idToken: String, versionID: String): MutableLiveData<Version?> {

            val call = api.getVersion(idToken, versionID) // The request included the token
            var version : Version?
            var to_return = MutableLiveData<Version?>()

            call.enqueue(object : Callback<Version> {
                override fun onResponse(call: Call<Version>, response: Response<Version>) {
                    Log.i(TAG, "DisplayVersionList: call enqueue")

                    if (!response.isSuccessful) {
                        Log.i(TAG, "CODE:" + response.code().toString())
                        return
                    }

                    version = response.body()

                    if (response != null) {
                        var content = ""
                        content += version?.toString() + "\n"
                        Log.i(TAG, "\n=========\n$content")
                        to_return.value = version
                    }
                }

                override fun onFailure(call: Call<Version>, t: Throwable) {
                    Log.i(TAG, "error CODE:" + t.message)
                }
            })
            return to_return
        }

     // Send offer
     fun sendOffer( TAG : String ,idToken : String , offer : OfferToPost) {
         val call = api.sendMyOffer(idToken,offer)
         Log.i(TAG, "CREATE OFFER")

         call.enqueue(object : Callback<ResponseBody> {
             override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                 Log.i(TAG, "CREATE ANNONCE")

                 if (!response.isSuccessful()) {
                     Log.i(TAG, "CREATED OFFER ")
                     Log.i(TAG, "CODE:" + response.code().toString() + "" + response.body().toString())

                     return
                 }

             }

             override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                 Log.i(TAG, "error CODE:" + t.message)
             }
         })
     }

        fun sendCommande(TAG: String, idToken: String, versionID: String, colorId: String, options: List<String>){
            val call = api.sendCommande(idToken, Commande(versionID, colorId, options))

            call.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.i(TAG, "sendCommande: call enqueue")

                    if (!response.isSuccessful) {
                        Log.i(TAG, "CODE:" + response.code().toString())
                        return
                    }
                    Log.i(TAG, "sendCommande => response:"+response.body())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.i(TAG, "error CODE:" + t.message)
                }
            })
        }
    }





}