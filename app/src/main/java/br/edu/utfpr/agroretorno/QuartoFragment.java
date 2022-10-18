package br.edu.utfpr.agroretorno;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import br.edu.utfpr.agroretorno.databinding.FragmentQuartoBinding;

public class QuartoFragment extends Fragment {

    private FragmentQuartoBinding binding;

    private TextView resultado;
    private EditText campo_vpl;
    private EditText campo_il;
    private EditText campo_tir;
    private EditText campo_payback;

    private static final String TAG_TIR = "TIR";

    private Bundle bundle;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentQuartoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String prazo_anos = "0";
        String somadescontos = "0";
        String vpl = "0";
        String il = "0";
        String tir = "0";
        String payback = "0";

        bundle = new Bundle();
        bundle = this.getArguments();

        if (bundle != null) {

            try {
                prazo_anos = bundle.getString("prazo_anos");
                somadescontos = bundle.getString("somadescontos").replace(',','.');
                vpl = bundle.getString("vpl").replace(',','.');
                il = bundle.getString("il").replace(',','.');
                tir = bundle.getString("tir").replace(',','.');
                payback = bundle.getString("payback");

                binding.campoSomadescontos.setEnabled(false);
                binding.campoSomadescontos.setText(somadescontos);

                //resultado = (TextView) findViewById(R.id.resultado);
                //campo_vpl = (EditText) findViewById(R.id.campo_vpl);
                binding.campoVpl.setEnabled(false);
                binding.campoVpl.setText(vpl);

                //campo_il = (EditText) findViewById(R.id.campo_il);
                binding.campoIl.setEnabled(false);
                binding.campoIl.setText(il);

                //campo_tir = (EditText) findViewById(R.id.campo_tir);
                binding.campoTir.setEnabled(false);
                binding.campoTir.setText(tir);

                binding.campoPayback.setEnabled(false);
                binding.campoPayback.setText(payback);

                String viabilidade;
                ImageView imagem = getView().findViewById(R.id.icone);
                int cor = Color.RED;
                if (Double.parseDouble(il) > 1) {
                    viabilidade = getResources().getString(R.string.rotulo_viavel);
                    cor = Color.BLUE;
                    binding.icone.setImageResource(R.drawable.ok);
                } else {
                    viabilidade = getResources().getString(R.string.rotulo_inviavel);
                    binding.icone.setImageResource(R.drawable.notok);
                }
                binding.resultado.setTextColor(cor);
                binding.resultado.setText(viabilidade);

            } catch (Exception e){
                Log.i(TAG_TIR,"Campos vazios ainda nao informados.", e);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}