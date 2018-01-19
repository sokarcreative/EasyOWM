package be.sokarcreative.easyowm.api


/**
 * Weather Icon View allows you to create Weather Icon for your Android application
 * It's based on Erik Flowers project located at: https://github.com/erikflowers/weather-icons
 * This project is open-source and can be found at: https://github.com/pwittchen/WeatherIconView
 * @author Piotr Wittchen
 */
class WeatherIconView : android.support.v7.widget.AppCompatTextView {
    private var weatherFont: android.graphics.Typeface? = null

    constructor(context: android.content.Context) : super(context) {
        initialize(context)
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet) : super(context, attrs) {
        initializeAttributes(context, attrs)
        initialize(context)
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initializeAttributes(context, attrs)
        initialize(context)
    }

    private fun initialize(context: android.content.Context) {
        if (isInEditMode) {
            return
        }
        weatherFont = android.graphics.Typeface.createFromAsset(context.getAssets(), be.sokarcreative.easyowm.api.WeatherIconView.Companion.PATH_TO_WEATHER_FONT)
        typeface = weatherFont
    }

    private fun initializeAttributes(context: android.content.Context, attrs: android.util.AttributeSet) {
        if (isInEditMode) {
            return
        }

        val typedArray = context.obtainStyledAttributes(attrs, be.sokarcreative.easyowm.R.styleable.WeatherIconView)
        initIconResource(typedArray)
        initIconSize(typedArray)
        initIconColor(typedArray)
        typedArray.recycle()
    }

    private fun initIconResource(typedArray: android.content.res.TypedArray) {
        val weatherIconCode = typedArray.getString(be.sokarcreative.easyowm.R.styleable.WeatherIconView_weatherIconResource)

        if (weatherIconCode == null || weatherIconCode.isEmpty()) {
            return
        }

        text = weatherIconCode
    }

    private fun initIconSize(typedArray: android.content.res.TypedArray) {
        val weatherIconSize = typedArray.getInt(be.sokarcreative.easyowm.R.styleable.WeatherIconView_weatherIconSize, be.sokarcreative.easyowm.api.WeatherIconView.Companion.DEFAULT_WEATHER_ICON_SIZE)
        textSize = weatherIconSize.toFloat()
    }

    private fun initIconColor(typedArray: android.content.res.TypedArray) {
        val weatherIconColor = typedArray.getColor(be.sokarcreative.easyowm.R.styleable.WeatherIconView_weatherIconColor, be.sokarcreative.easyowm.api.WeatherIconView.Companion.DEFAULT_WEATHER_ICON_COLOR)
        setTextColor(weatherIconColor)
    }

    /**
     * sets weather icon basing on String resources
     * Icons are created from weather-icons TTF font by Erik Flowers
     * Full icons reference can be found at: http://erikflowers.github.io/weather-icons/
     * @param iconCode icon code located in res/values/strings.xml file
     */
    fun setIconResource(iconCode: String) {
        text = iconCode
    }

    /**
     * sets icon size
     * @param size icon size as an integer; default size is equal to 100
     */
    fun setIconSize(size: Int) {
        textSize = size.toFloat()
    }

    /**
     * sets icon color resource
     * @param colorResource color resource - eg. Color.RED or any custom color; default is Color.BLACK
     */
    fun setIconColor(colorResource: Int) {
        setTextColor(colorResource)
    }

    companion object {
        private val PATH_TO_WEATHER_FONT = "fonts/weathericons-regular-webfont.ttf"
        private val DEFAULT_WEATHER_ICON_SIZE = 100
        private val DEFAULT_WEATHER_ICON_COLOR = android.graphics.Color.BLACK
    }
}