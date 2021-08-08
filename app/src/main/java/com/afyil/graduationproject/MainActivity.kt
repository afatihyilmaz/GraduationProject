package com.afyil.graduationproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.afyil.graduationproject.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    val trackFragment = TrackFragment()
    val homeFragment = HomeFragment()
    val priceCalculationFragment = PriceCalculationFragment()
    val profileFragment = ProfileFragment()
    val loginFragment = LoginFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCurrentFragment(homeFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.priceCalc -> makeCurrentFragment(priceCalculationFragment)
                R.id.profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

        val buttoncheck = findViewById<Button>(R.id.buttonHomeLoginRegister)

        buttoncheck.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                makeCurrentFragment(loginFragment)
            }
        })


    }

     fun toLoginRegisterFragment(view: View){
         makeCurrentFragment(loginFragment)
     }

     public fun trackCheck(view: View){
         makeCurrentFragment(trackFragment)

     }

    public fun trackbutton2(view: View){
        makeCurrentFragment(trackFragment)
    }



    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        addToBackStack(null)
        commit()
    }

  }