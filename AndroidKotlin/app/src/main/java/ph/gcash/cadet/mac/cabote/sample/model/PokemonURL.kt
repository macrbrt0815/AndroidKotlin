package ph.gcash.cadet.mac.cabote.sample.model

import com.google.gson.annotations.SerializedName

class PokemonURL {
    @SerializedName("name")
    var name = ""

    @SerializedName("url")
    var url = ""

    constructor(name: String, url:String){
        this.name = name
        this.url = url
    }
}