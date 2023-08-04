package com.rammy.pricepridict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.rammy.pricepridict.api.responce
import com.rammy.pricepridict.api.retrofitinstance
import com.rammy.pricepridict.api.sendResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.String as String1

class MainActivity : AppCompatActivity() {
    lateinit var text_sqft:TextInputEditText
    lateinit var location_autocomplete:AutoCompleteTextView
    lateinit var bath_autocomplete:AutoCompleteTextView
    lateinit var bhk_autocomplete:AutoCompleteTextView
    lateinit var textview:TextView
    lateinit var button: Button
    var location:String1=""
    var bath: String1=""
    var bhk: String1=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //location
        var items_location=listOf("1st Block Jayanagar","1st Block Koramangala",
            "1st Phase JP Nagar", "2nd Phase Judicial Layout",
            "2nd Stage Nagarbhavi", "5th Block Hbr Layout",
            "5th Phase JP Nagar", "6th Phase JP Nagar", "7th Phase JP Nagar"
            /*
            '8th Phase JP Nagar', '9th Phase JP Nagar', 'AECS Layout',
            'Abbigere', 'Akshaya Nagar', 'Ambalipura', 'Ambedkar Nagar',
            'Amruthahalli', 'Anandapura', 'Ananth Nagar', 'Anekal',
            'Anjanapura', 'Ardendale', 'Arekere', 'Attibele', 'BEML Layout',
            'BTM 1st Stage', 'BTM 2nd Stage', 'BTM Layout', 'Babusapalaya',
            'Badavala Nagar', 'Balagere', 'Banashankari',
            'Banashankari Stage II', 'Banashankari Stage III',
            'Banashankari Stage V', 'Banashankari Stage VI', 'Banaswadi',
            'Banjara Layout', 'Bannerghatta', 'Bannerghatta Road', 'Basapura',
            'Basavangudi', 'Basaveshwara Nagar', 'Battarahalli', 'Begur',
            'Begur Road', 'Bellandur', 'Benson Town', 'Bharathi Nagar',
            'Bhoganhalli', 'Billekahalli', 'Binny Pete', 'Bisuvanahalli',
            'Bommanahalli', 'Bommasandra', 'Bommasandra Industrial Area',
            'Bommenahalli', 'Brookefield', 'Budigere', 'CV Raman Nagar',
            'Chamrajpet', 'Chandapura', 'Channasandra', 'Chikka Tirupathi',
            'Chikkabanavar', 'Chikkalasandra', 'Choodasandra', 'Cooke Town',
            'Cox Town', 'Cunningham Road', 'Dairy Circle', 'Dasanapura',
            'Dasarahalli', 'Devanahalli', 'Devarachikkanahalli',
            'Dodda Nekkundi', 'Doddaballapur', 'Doddakallasandra',
            'Doddathoguru', 'Dodsworth Layout', 'Domlur', 'Dommasandra',
            'EPIP Zone', 'Electronic City', 'Electronic City Phase II',
            'Electronics City Phase 1', 'Frazer Town', 'GM Palaya',
            'Ganga Nagar', 'Garudachar Palya', 'Giri Nagar',
            'Gollarapalya Hosahalli', 'Gottigere', 'Green Glen Layout',
            'Gubbalala', 'Gunjur', 'Gunjur Palya', 'HAL 2nd Stage',
            'HBR Layout', 'HRBR Layout', 'HSR Layout', 'Haralur Road',
            'Harlur', 'Hebbal', 'Hebbal Kempapura', 'Hegde Nagar', 'Hennur',
            'Hennur Road', 'Hoodi', 'Horamavu Agara', 'Horamavu Banaswadi',
            'Hormavu', 'Hosa Road', 'Hosakerehalli', 'Hoskote', 'Hosur Road',
            'Hulimavu', 'ISRO Layout', 'ITPL', 'Iblur Village', 'Indira Nagar',
            'JP Nagar', 'Jakkur', 'Jalahalli', 'Jalahalli East', 'Jigani',
            'Judicial Layout', 'KR Puram', 'Kadubeesanahalli', 'Kadugodi',
            'Kaggadasapura', 'Kaggalipura', 'Kaikondrahalli',
            'Kalena Agrahara', 'Kalkere', 'Kalyan nagar', 'Kambipura',
            'Kammanahalli', 'Kammasandra', 'Kanakapura', 'Kanakpura Road',
            'Kannamangala', 'Karuna Nagar', 'Kasavanhalli', 'Kasturi Nagar',
            'Kathriguppe', 'Kaval Byrasandra', 'Kenchenahalli', 'Kengeri',
            'Kengeri Satellite Town', 'Kereguddadahalli', 'Kodichikkanahalli',
            'Kodigehaali', 'Kodigehalli', 'Kodihalli', 'Kogilu', 'Konanakunte',
            'Koramangala', 'Kothannur', 'Kothanur', 'Kudlu', 'Kudlu Gate',
            'Kumaraswami Layout', 'Kundalahalli', 'LB Shastri Nagar',
            'Laggere', 'Lakshminarayana Pura', 'Lingadheeranahalli',
            'Magadi Road', 'Mahadevpura', 'Mahalakshmi Layout', 'Mallasandra',
            'Malleshpalya', 'Malleshwaram', 'Marathahalli', 'Margondanahalli',
            'Marsur', 'Mico Layout', 'Munnekollal', 'Murugeshpalya',
            'Mysore Road', 'NGR Layout', 'NRI Layout', 'Nagadevanahalli',
            'Naganathapura', 'Nagappa Reddy Layout', 'Nagarbhavi',
            'Nagasandra', 'Nagavara', 'Nagavarapalya', 'Narayanapura',
            'Neeladri Nagar', 'Nehru Nagar', 'OMBR Layout', 'Old Airport Road',
            'Old Madras Road', 'Padmanabhanagar', 'Pai Layout', 'Panathur',
            'Parappana Agrahara', 'Pattandur Agrahara', 'Poorna Pragna Layout',
            'Prithvi Layout', 'R.T. Nagar', 'Rachenahalli',
            'Raja Rajeshwari Nagar', 'Rajaji Nagar', 'Rajiv Nagar',
            'Ramagondanahalli', 'Ramamurthy Nagar', 'Rayasandra',
            'Sadashiva Nagar', 'Sahakara Nagar', 'Sanjay nagar',
            'Sarakki Nagar', 'Sarjapur', 'Sarjapur  Road',
            'Sarjapura - Attibele Road', 'Sector 1 HSR Layout',
            'Sector 2 HSR Layout', 'Sector 7 HSR Layout', 'Seegehalli',
            'Shampura', 'Shivaji Nagar', 'Singasandra', 'Somasundara Palya',
            'Sompura', 'Sonnenahalli', 'Subramanyapura', 'Sultan Palaya',
            'TC Palaya', 'Talaghattapura', 'Thanisandra', 'Thigalarapalya',
            'Thubarahalli', 'Thyagaraja Nagar', 'Tindlu', 'Tumkur Road',
            'Ulsoor', 'Uttarahalli', 'Varthur', 'Varthur Road', 'Vasanthapura',
            'Vidyaranyapura', 'Vijayanagar', 'Vishveshwarya Layout',
            'Vishwapriya Layout', 'Vittasandra', 'Whitefield',
            'Yelachenahalli', 'Yelahanka', 'Yelahanka New Town', 'Yelenahalli',
            'Yeshwanthpur', 'other'*/)
        location_autocomplete=findViewById(R.id.location)
        val adapter=ArrayAdapter(this,R.layout.list_item_loc,items_location)
        location_autocomplete.setAdapter(adapter)
        location_autocomplete.onItemClickListener=AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            var itemselected=adapterView.getItemAtPosition(i)
            location= itemselected.toString()
            //Toast.makeText(this,"Item:$location",Toast.LENGTH_SHORT).show()
        }
        //bath
        var items_bath=listOf("4.0",  "3.0",  "2.0",  "5.0",  "1.0",  "6.0",  "8.0",  "7.0",  "9.0", "16.0", "12.0", "13.0")
        bath_autocomplete=findViewById(R.id.bath)
        val adapter1=ArrayAdapter(this,R.layout.bath_list,items_bath)
        bath_autocomplete.setAdapter(adapter1)
        bath_autocomplete.onItemClickListener=AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            var itemselected=adapterView.getItemAtPosition(i)
            bath= itemselected.toString()
            //Toast.makeText(this,"Item:$bath",Toast.LENGTH_SHORT).show()
        }
        //bhk
        var items_bhk=listOf("4",  "3", "2",  "5",  "1",  "6",  "8",  "7",  "9", "11", "16", "10", "13")
        bhk_autocomplete=findViewById(R.id.bhk)
        val adapter2=ArrayAdapter(this,R.layout.bhk_list,items_bhk)
        bhk_autocomplete.setAdapter(adapter2)
        bhk_autocomplete.onItemClickListener=AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            var itemselected=adapterView.getItemAtPosition(i)
            bhk= itemselected.toString()
            //Toast.makeText(this,"Item:$bath",Toast.LENGTH_SHORT).show()
        }
        textview=findViewById(R.id.text_view_id)
        //sqft
        text_sqft=findViewById(R.id.sqft)
        val sqft_text=text_sqft.text.toString()
        button=findViewById(R.id.predict)
        //val send=sendResponce(location,bhk,bath,sqft_text)
        var send=sendResponce(location,bhk,bath,sqft_text)
        button.setOnClickListener {
            Log.d("1111",location)
            Log.d("1112",bhk)
            Log.d("1113",bath)
            Log.d("1114",sqft_text)
            retrofitinstance.api.pridict(send).enqueue(object : Callback<List<responce>>{
                override fun onFailure(call: Call<List<responce>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,t.toString(),Toast.LENGTH_LONG).show()
                    Log.d("0000",t.toString())
                }

                override fun onResponse(
                    call: Call<List<responce>>,
                    response: Response<List<responce>>,
                ) {
                    if (response.isSuccessful)
                    {
                        for (i in response.body()!!)
                        {
                            textview.text="Predicated price: "+i.prediction.toString()
                        }
                    }
                }

            })

        }


    }
}