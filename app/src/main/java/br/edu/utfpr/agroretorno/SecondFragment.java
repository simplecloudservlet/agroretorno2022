package br.edu.utfpr.agroretorno;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import br.edu.utfpr.agroretorno.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private TableLayout agroretorno_view;

    private Button botao_avancar;
    private EditText campo_prazo_anos, campo_investimento, campo_juros;
    private EditText ano1,ano2,ano3,ano4,ano5,ano6,ano7,ano8,ano9,ano10;

    private int maximo_anos=24;

    private String prazo_anos, investimento, juros;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        campo_investimento = (EditText) getView().findViewById(R.id.campo_investimento);
        campo_juros = (EditText) getView().findViewById(R.id.campo_juros);

        Spinner spinner = (Spinner) getView().findViewById(R.id.campo_prazo_anos);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.lista_anos, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                prazo_anos = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> spinnerAdap = (ArrayAdapter<String>) spinner.getAdapter();
        int spinnerPosition = spinnerAdap.getPosition("10");
        spinner.setSelection(spinnerPosition);

        binding.botaoAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                investimento = campo_investimento.getText().toString();
                juros = campo_juros.getText().toString();

                bundle.putString("prazo_anos", prazo_anos); //chave-valor
                bundle.putString("investimento", investimento); //chave-valor
                bundle.putString("juros", juros); //chave-valor
                bundle.putString("maximo_anos", maximo_anos+"");

                SecondFragment.this.setArguments(bundle);

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_TerceiroFragment,bundle);
            }
        });

        binding.botaoRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}