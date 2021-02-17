package com.example.myapplication.navigation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.App
import com.example.myapplication.R
import com.example.myapplication.data.repository.RepositoryImpl
import me.relex.circleindicator.CircleIndicator3

class HomeFragment : Fragment() {

    private lateinit var v: View
    private var top3ImagesList = ArrayList<String>()
    private var popularImagesList = ArrayList<String>()
    private var recentImageList = ArrayList<String>()

    private lateinit var vp_top3: ViewPager2
    private lateinit var indicator: CircleIndicator3

    private lateinit var rv_popular: RecyclerView
    private lateinit var rv_recent : RecyclerView

    private val repository = RepositoryImpl()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_home, container, false)

        setTop3()
        setPopular()
        setRecent()

        return v
    }

    private fun setTop3() {
        top3ImagesList.clear()

        top3ImagesList.add("https://rgo4.com/files/attach/images/2681740/024/470/011/70c03f4555eaf6da08fcd9af5f0fe481.JPG")
        top3ImagesList.add("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F99D4F9485C00048B0AA529")
        top3ImagesList.add("https://t1.daumcdn.net/cfile/tistory/9954B44D5B0AB2E22C")

        vp_top3 = v.findViewById(R.id.vp_top3)
        vp_top3.adapter = MultiViewAdapter(1,top3ImagesList)
        vp_top3.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        indicator = v.findViewById(R.id.indicator)
        indicator.setViewPager(vp_top3)
    }

    private fun setPopular() {
        popularImagesList.clear()

        for (i in 1..9){
            popularImagesList.add("https://img1.daumcdn.net/thumb/R720x0/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fliveboard%2Fcemmarketing%2F4809ea274cd54953a66fa76f22a6edb8.JPG")
        }

        rv_popular = v.findViewById(R.id.rv_popular)
        rv_popular.layoutManager = GridLayoutManager(App.instance, 3)
        rv_popular.adapter = MultiViewAdapter(2,popularImagesList)
    }

    private fun setRecent() {
        recentImageList.clear()

        recentImageList.add("https://rgo4.com/files/attach/images/2681740/024/470/011/70c03f4555eaf6da08fcd9af5f0fe481.JPG")
        recentImageList.add("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile4.uf.tistory.com%2Fimage%2F99D4F9485C00048B0AA529")
        recentImageList.add("https://t1.daumcdn.net/cfile/tistory/9954B44D5B0AB2E22C")

        rv_recent = v.findViewById(R.id.rv_recent)
        rv_recent.layoutManager = LinearLayoutManager(App.instance, RecyclerView.VERTICAL, false)
        rv_recent.adapter = MultiViewAdapter(3,recentImageList)
    }
}