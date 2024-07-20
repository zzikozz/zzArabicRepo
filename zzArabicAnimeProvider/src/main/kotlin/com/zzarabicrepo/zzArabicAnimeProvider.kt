package com.zzarabicrepo

import android.util.Log
import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.ExtractorLink
import com.lagradost.cloudstream3.utils.httpsify
import com.lagradost.cloudstream3.utils.loadExtractor
import org.jsoup.Jsoup

class zzArabicAnimeProvider(val plugin: zzArabicAnimePlugin) : MainAPI() { // all providers must be an intstance of MainAPI
    override var mainUrl = "https://animezid.show"
    override var name = "Gogoflix"

    override val hasMainPage = true
    override var lang = "ar"
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)


    override val mainPage = mainPageOf(
        Pair("dub", "أنمي مدبلج"),
    )
    override suspend fun loadLinks(
        data: String, // fournit par load()
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ): Boolean {

        val url = "https://dugrt.com/post14/?post=eyJob21lVXJsIjoiaHR0cHM6XC9cL2FuaW1lemlkLnNob3ciLCJ3YXRjaFVybCI6Imh0dHBzOlwvXC9hbmltZXppZC5zaG93XC9wbGF5LnBocD92aWQ9NThkYmM0ZmM3IiwiZG93bmxvYWQxMDgwIjp7Ikxpbmtib3giOiJodHRwczpcL1wvd3d3Lmxpbmtib3gudG9cL2ZpbGVcL2ZwM2xnODAwMmVzaSIsIlVwdG9ib3giOiJodHRwczpcL1wvdXB0b2JveC5jb21cLzJuN2RoemE0NTdrciIsIjFmaWNoaWVyIjoiaHR0cHM6XC9cLzFmaWNoaWVyLmNvbVwvP3ZpcnhzeGpnZm54b2d3ZXdvOXluIiwiQW5vbmZpbGVzIjoiaHR0cHM6XC9cL2Fub25maWxlcy5jb21cLzRjbzlHNFNheTYiLCJCYXlmaWxlcyI6Imh0dHBzOlwvXC9iYXlmaWxlcy5jb21cLzVibzZHM1M2eWIiLCJVcGJhbSI6Imh0dHBzOlwvXC91cGJhbS5vcmdcL3dzZG9iZzN2OHR1aCIsIkZpbGUtdXBsb2FkIjoiaHR0cHM6XC9cL3d3dy5maWxlLXVwbG9hZC5jb21cL2NiaG53dnR2YzZxZiIsIkxldHN1cGxvYWQiOiJodHRwczpcL1wvbGV0c3VwbG9hZC5pb1wvMkIyZDJcL1thbmltZXppZC5vcmddLkRyLlN0b25lLlMwMUUwMS5XRUItREwuMTA4MHAuRHViYmVkLkFyLm1wNCJ9LCJkb3dubG9hZDcyMCI6IiIsImRvd25sb2FkMjY1IjoiIiwic2VydmVycyI6eyJaaWR3aXNoIjoiaHR0cHM6XC9cL3ppZHdpc2guc2l0ZVwvZVwvdW1tM2N6bjBtbG1mIiwiQmVzdHgiOiJodHRwczpcL1wvYmVzdHguc3RyZWFtXC92XC9MR1FrQVUxWnRsNWhcLyIsIkRzMnBsYXkiOiJodHRwczpcL1wvZHMycGxheS5jb21cL2VcLzhyY3dhNjAxMTRjbiIsIldzeGUiOiJodHRwczpcL1wvd3N4ZS52aWlkc2hhci5jb21cL2VtYmVkLWk5enA0dHJkMHlyNS5odG1sIiwiUXF3NiI6Imh0dHBzOlwvXC9xcXc2LnZhZGJhbS5uZXRcL2VtYmVkLXIzMzI1cDd0empvNi5odG1sIiwiVXFsb2FkIjoiaHR0cHM6XC9cL3VxbG9hZC53c1wvZW1iZWQtZGExeXIzM3FpMXhkLmh0bWwiLCJVcHRvc3RyZWFtIjoiaHR0cHM6XC9cL3VwdG9zdHJlYW0uZXVcL2lmcmFtZVwvMm43ZGh6YTQ1N2tyICJ9fQ=="
        val referer = "https://animezid.show/watch.php?vid=58dbc4fc7"
        val document = app.get(url, referer = referer).document
        val link = document.select("ul.serversList > li").apmap {

           val link = Jsoup.parse(it.attr("data-server")).attr("src")
           Log.d("zzikozz", "link: $link")


            loadExtractor(
                link,
                url,
                subtitleCallback,
                callback)
            }

    return true
    }


    override suspend fun load(url: String): LoadResponse {
        return newMovieLoadResponse("","", TvType.Anime, "")
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val url = "https://dugrt.com/post14/?post=eyJob21lVXJsIjoiaHR0cHM6XC9cL2FuaW1lemlkLnNob3ciLCJ3YXRjaFVybCI6Imh0dHBzOlwvXC9hbmltZXppZC5zaG93XC9wbGF5LnBocD92aWQ9NThkYmM0ZmM3IiwiZG93bmxvYWQxMDgwIjp7Ikxpbmtib3giOiJodHRwczpcL1wvd3d3Lmxpbmtib3gudG9cL2ZpbGVcL2ZwM2xnODAwMmVzaSIsIlVwdG9ib3giOiJodHRwczpcL1wvdXB0b2JveC5jb21cLzJuN2RoemE0NTdrciIsIjFmaWNoaWVyIjoiaHR0cHM6XC9cLzFmaWNoaWVyLmNvbVwvP3ZpcnhzeGpnZm54b2d3ZXdvOXluIiwiQW5vbmZpbGVzIjoiaHR0cHM6XC9cL2Fub25maWxlcy5jb21cLzRjbzlHNFNheTYiLCJCYXlmaWxlcyI6Imh0dHBzOlwvXC9iYXlmaWxlcy5jb21cLzVibzZHM1M2eWIiLCJVcGJhbSI6Imh0dHBzOlwvXC91cGJhbS5vcmdcL3dzZG9iZzN2OHR1aCIsIkZpbGUtdXBsb2FkIjoiaHR0cHM6XC9cL3d3dy5maWxlLXVwbG9hZC5jb21cL2NiaG53dnR2YzZxZiIsIkxldHN1cGxvYWQiOiJodHRwczpcL1wvbGV0c3VwbG9hZC5pb1wvMkIyZDJcL1thbmltZXppZC5vcmddLkRyLlN0b25lLlMwMUUwMS5XRUItREwuMTA4MHAuRHViYmVkLkFyLm1wNCJ9LCJkb3dubG9hZDcyMCI6IiIsImRvd25sb2FkMjY1IjoiIiwic2VydmVycyI6eyJaaWR3aXNoIjoiaHR0cHM6XC9cL3ppZHdpc2guc2l0ZVwvZVwvdW1tM2N6bjBtbG1mIiwiQmVzdHgiOiJodHRwczpcL1wvYmVzdHguc3RyZWFtXC92XC9MR1FrQVUxWnRsNWhcLyIsIkRzMnBsYXkiOiJodHRwczpcL1wvZHMycGxheS5jb21cL2VcLzhyY3dhNjAxMTRjbiIsIldzeGUiOiJodHRwczpcL1wvd3N4ZS52aWlkc2hhci5jb21cL2VtYmVkLWk5enA0dHJkMHlyNS5odG1sIiwiUXF3NiI6Imh0dHBzOlwvXC9xcXc2LnZhZGJhbS5uZXRcL2VtYmVkLXIzMzI1cDd0empvNi5odG1sIiwiVXFsb2FkIjoiaHR0cHM6XC9cL3VxbG9hZC53c1wvZW1iZWQtZGExeXIzM3FpMXhkLmh0bWwiLCJVcHRvc3RyZWFtIjoiaHR0cHM6XC9cL3VwdG9zdHJlYW0uZXVcL2lmcmFtZVwvMm43ZGh6YTQ1N2tyICJ9fQ=="
        val referer = "https://animezid.show/watch.php?vid=58dbc4fc7"
        val document = app.get(url, referer = referer).document
        //val link = document.select("ul.serversList > li")
        Log.d("zzikozz", "document: $document")

        val searchResponses = mutableListOf<SearchResponse>()
        searchResponses.add(
            newMovieSearchResponse("", "")
        )

        return newHomePageResponse(request.name,  searchResponses)
    }

    // this function gets called when you search for something
    override suspend fun search(query: String): List<SearchResponse> {
        return listOf<SearchResponse>()
    }
}