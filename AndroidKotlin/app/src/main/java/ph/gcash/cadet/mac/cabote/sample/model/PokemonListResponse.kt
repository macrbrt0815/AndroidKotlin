package ph.gcash.cadet.mac.cabote.sample.model

import com.google.gson.annotations.SerializedName
import ph.gcash.cadet.mac.cabote.sample.api.PokemonAPI

class PokemonListResponse {
    @SerializedName("count")
    var count: Int = -1

    @SerializedName("next")
    var next: String? = ""

    @SerializedName("previous")
    var previous: String? = ""

    @SerializedName("results")
    var pokemonList: ArrayList<PokemonURL> = ArrayList<PokemonURL>()
}