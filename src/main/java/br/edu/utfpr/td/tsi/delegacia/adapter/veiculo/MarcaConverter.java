package br.edu.utfpr.td.tsi.delegacia.adapter.veiculo;

import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Marca;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MarcaConverter implements AttributeConverter<Marca, String> {

    @Override
    public String convertToDatabaseColumn(Marca marca) {
        if (marca == null)
            return null;

        return marca.getMarca();
    }

    @Override
    public Marca convertToEntityAttribute(String str) {
        try {
            return new Marca(str);
        } catch (Exception e) {
            return null;
        }
    }
}
