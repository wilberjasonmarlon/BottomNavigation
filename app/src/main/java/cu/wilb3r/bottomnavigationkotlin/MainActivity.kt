 package cu.wilb3r.bottomnavigationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import cu.wilb3r.bottomnavigationkotlin.databinding.ActivityMainBinding
import cu.wilb3r.bottomnavigationkotlin.ui.BuysFragment
import cu.wilb3r.bottomnavigationkotlin.ui.HomeFragment
import cu.wilb3r.bottomnavigationkotlin.ui.ProfileFragment

 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(HomeFragment(), "home")
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    setFragment(HomeFragment(), "home")
                }
                R.id.menu_buy -> {
                    setFragment(BuysFragment(), "buy")
                }
                R.id.menu_profile -> {
                    setFragment(ProfileFragment(), "profile")
                }
            }
            true
        }

        setBudge(R.id.menu_buy, 9)

    }

     private fun setFragment(fragment: Fragment, tag: String) {
         supportFragmentManager.beginTransaction().apply {
             replace(R.id.frgContainer, fragment, tag)
             commit()
         }
     }

     fun setBudge(resourse: Int, count: Int) =
         binding.bottomNavigationView.getOrCreateBadge(resourse).apply {
             number = count
             isVisible = true
         }
}