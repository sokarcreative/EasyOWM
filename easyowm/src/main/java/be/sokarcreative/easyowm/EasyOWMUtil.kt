package be.sokarcreative.easyowm

/**
 * Created by sokarcreative on 25/05/2017.
 * Contact : marinx.denis@gmail.com
 */
object QuickWeatherUtil {

    val day200 = "day200"
    val day201 = "day201"
    val day202 = "day202"
    val day210 = "day210"
    val day211 = "day211"
    val day212 = "day212"
    val day221 = "day221"
    val day230 = "day230"
    val day231 = "day231"
    val day232 = "day232"
    val day300 = "day300"
    val day301 = "day301"
    val day302 = "day302"
    val day310 = "day310"
    val day311 = "day311"
    val day312 = "day312"
    val day313 = "day313"
    val day314 = "day314"
    val day321 = "day321"
    val day500 = "day500"
    val day501 = "day501"
    val day502 = "day502"
    val day503 = "day503"
    val day504 = "day504"
    val day511 = "day511"
    val day520 = "day520"
    val day521 = "day521"
    val day522 = "day522"
    val day531 = "day531"
    val day600 = "day600"
    val day601 = "day601"
    val day602 = "day602"
    val day611 = "day611"
    val day612 = "day612"
    val day615 = "day615"
    val day616 = "day616"
    val day620 = "day620"
    val day621 = "day621"
    val day622 = "day622"
    val day701 = "day701"
    val day711 = "day711"
    val day721 = "day721"
    val day731 = "day731"
    val day741 = "day741"
    val day761 = "day761"
    val day762 = "day762"
    val day781 = "day781"
    val day800 = "day800"
    val day801 = "day801"
    val day802 = "day802"
    val day803 = "day803"
    val day804 = "day804"
    val day900 = "day900"
    val day902 = "day902"
    val day903 = "day903"
    val day904 = "day904"
    val day906 = "day906"
    val day951 = "day951"
    val day952 = "day952"
    val day953 = "day953"
    val day954 = "day954"
    val day955 = "day955"
    val day956 = "day956"
    val day957 = "day957"
    val day958 = "day958"
    val day959 = "day959"
    val day960 = "day960"
    val day961 = "day961"
    val day962 = "day962"
    val night200 = "night200"
    val night201 = "night201"
    val night202 = "night202"
    val night210 = "night210"
    val night211 = "night211"
    val night212 = "night212"
    val night221 = "night221"
    val night230 = "night230"
    val night231 = "night231"
    val night232 = "night232"
    val night300 = "night300"
    val night301 = "night301"
    val night302 = "night302"
    val night310 = "night310"
    val night311 = "night311"
    val night312 = "night312"
    val night313 = "night313"
    val night314 = "night314"
    val night321 = "night321"
    val night500 = "night500"
    val night501 = "night501"
    val night502 = "night502"
    val night503 = "night503"
    val night504 = "night504"
    val night511 = "night511"
    val night520 = "night520"
    val night521 = "night521"
    val night522 = "night522"
    val night531 = "night531"
    val night600 = "night600"
    val night601 = "night601"
    val night602 = "night602"
    val night611 = "night611"
    val night612 = "night612"
    val night615 = "night615"
    val night616 = "night616"
    val night620 = "night620"
    val night621 = "night621"
    val night622 = "night622"
    val night701 = "night701"
    val night711 = "night711"
    val night721 = "night721"
    val night731 = "night731"
    val night741 = "night741"
    val night761 = "night761"
    val night762 = "night762"
    val night781 = "night781"
    val night800 = "night800"
    val night801 = "night801"
    val night802 = "night802"
    val night803 = "night803"
    val night804 = "night804"
    val night900 = "night900"
    val night902 = "night902"
    val night903 = "night903"
    val night904 = "night904"
    val night906 = "night906"
    val night951 = "night951"
    val night952 = "night952"
    val night953 = "night953"
    val night954 = "night954"
    val night955 = "night955"
    val night956 = "night956"
    val night957 = "night957"
    val night958 = "night958"
    val night959 = "night959"
    val night960 = "night960"
    val night961 = "night961"
    val night962 = "night962"


    fun getWeatherIcon(weatherId: String?, weatherIcon: String?): String {
        if (!(weatherId != null && !weatherId.isEmpty() && weatherIcon != null && !weatherIcon.isEmpty())) {
            return ""
        }
        val iconToTest = (if (weatherIcon.endsWith("d")) "day" else "night") + weatherId
        when (iconToTest) {
            day200 -> return "\uf010"
            day201 -> return "\uf010"
            day202 -> return "\uf010"
            day210 -> return "\uf005"
            day211 -> return "\uf005"
            day212 -> return "\uf005"
            day221 -> return "\uf005"
            day230 -> return "\uf010"
            day231 -> return "\uf010"
            day232 -> return "\uf010"
            day300 -> return "\uf00b"
            day301 -> return "\uf00b"
            day302 -> return "\uf008"
            day310 -> return "\uf008"
            day311 -> return "\uf008"
            day312 -> return "\uf008"
            day313 -> return "\uf008"
            day314 -> return "\uf008"
            day321 -> return "\uf00b"
            day500 -> return "\uf00b"
            day501 -> return "\uf008"
            day502 -> return "\uf008"
            day503 -> return "\uf008"
            day504 -> return "\uf008"
            day511 -> return "\uf006"
            day520 -> return "\uf009"
            day521 -> return "\uf009"
            day522 -> return "\uf009"
            day531 -> return "\uf00e"
            day600 -> return "\uf00a"
            day601 -> return "\uf0b2"
            day602 -> return "\uf00a"
            day611 -> return "\uf006"
            day612 -> return "\uf006"
            day615 -> return "\uf006"
            day616 -> return "\uf006"
            day620 -> return "\uf006"
            day621 -> return "\uf00a"
            day622 -> return "\uf00a"
            day701 -> return "\uf009"
            day711 -> return "\uf062"
            day721 -> return "\uf0b6"
            day731 -> return "\uf063"
            day741 -> return "\uf003"
            day761 -> return "\uf063"
            day762 -> return "\uf063"
            day781 -> return "\uf056"
            day800 -> return "\uf00d"
            day801 -> return "\uf000"
            day802 -> return "\uf000"
            day803 -> return "\uf000"
            day804 -> return "\uf00c"
            day900 -> return "\uf056"
            day902 -> return "\uf073"
            day903 -> return "\uf076"
            day904 -> return "\uf072"
            day906 -> return "\uf004"
            day957 -> return "\uf050"
            night200 -> return "\uf02d"
            night201 -> return "\uf02d"
            night202 -> return "\uf02d"
            night210 -> return "\uf025"
            night211 -> return "\uf025"
            night212 -> return "\uf025"
            night221 -> return "\uf025"
            night230 -> return "\uf02d"
            night231 -> return "\uf02d"
            night232 -> return "\uf02d"
            night300 -> return "\uf02b"
            night301 -> return "\uf02b"
            night302 -> return "\uf028"
            night310 -> return "\uf028"
            night311 -> return "\uf028"
            night312 -> return "\uf028"
            night313 -> return "\uf028"
            night314 -> return "\uf028"
            night321 -> return "\uf02b"
            night500 -> return "\uf02b"
            night501 -> return "\uf028"
            night502 -> return "\uf028"
            night503 -> return "\uf028"
            night504 -> return "\uf028"
            night511 -> return "\uf026"
            night520 -> return "\uf029"
            night521 -> return "\uf029"
            night522 -> return "\uf029"
            night531 -> return "\uf02c"
            night600 -> return "\uf02a"
            night601 -> return "\uf0b4"
            night602 -> return "\uf02a"
            night611 -> return "\uf026"
            night612 -> return "\uf026"
            night615 -> return "\uf026"
            night616 -> return "\uf026"
            night620 -> return "\uf026"
            night621 -> return "\uf02a"
            night622 -> return "\uf02a"
            night701 -> return "\uf029"
            night711 -> return "\uf062"
            night721 -> return "\uf0b6"
            night731 -> return "\uf063"
            night741 -> return "\uf04a"
            night761 -> return "\uf063"
            night762 -> return "\uf063"
            night781 -> return "\uf056"
            night800 -> return "\uf02e"
            night801 -> return "\uf022"
            night802 -> return "\uf022"
            night803 -> return "\uf022"
            night804 -> return "\uf086"
            night900 -> return "\uf056"
            night902 -> return "\uf073"
            night903 -> return "\uf076"
            night904 -> return "\uf072"
            night906 -> return "\uf024"
            night957 -> return "\uf050"
        }
        return ""
    }

    val humidityIcon: String
        get() = "\uf07a"
    val thermometerIcon: String
        get() = "\uf055"
    val windIcon: String
        get() = "\uf050"

}
