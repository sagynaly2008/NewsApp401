package kg.geektech.newsapp40;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import kg.geektech.models.News;
import kg.geektech.newsapp40.databinding.FragmentNewsBinding;

public class NewsFragment extends Fragment {
    private FragmentNewsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                save();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void save() {
        Bundle bundle = new Bundle();

        long created = System.currentTimeMillis();
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(created).atZone(ZoneId.of("Asia/Bishkek"));
        String format = zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm , dd MMM yyyy"));
        News news = new News(binding.editText.getText().toString(), format,  "");
        bundle.putSerializable("news", news);
        getParentFragmentManager().setFragmentResult("rk_news", bundle);
        App.database.newsDao().insetNews(news);
        close();
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}