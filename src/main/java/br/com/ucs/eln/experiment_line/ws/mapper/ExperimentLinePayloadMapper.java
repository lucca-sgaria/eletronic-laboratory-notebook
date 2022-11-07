package br.com.ucs.eln.experiment_line.ws.mapper;

import br.com.ucs.eln.experiment_line.model.ExperimentLine;
import br.com.ucs.eln.experiment_line.ws.model.ExperimentLinePayload;
import br.com.ucs.eln.globals.DateUtil;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.List;

@RequestScoped
public class ExperimentLinePayloadMapper {

    public List<ExperimentLinePayload> map(List<ExperimentLine> lineList) {
        return lineList
                .stream()
                .map(this::map)
                .toList();
    }

    public ExperimentLinePayload map(ExperimentLine line) {
        var payload = new ExperimentLinePayload();
        payload.setId(line.getId());
        payload.setCreationDate(formatDate(line.getCreated()));
        payload.setCompoundName(line.getSubstance().getName());
        payload.setCompoundMolarMass(line.getSubstance().getMolarMass());
        payload.setAmount(line.getAmount());
        payload.setMoles(line.getMoles());
        payload.setType(line.getType().name());

        return payload;
    }

    private static String formatDate(LocalDateTime date) {
        if (date == null) return null;

        return DateUtil.formatDate(date);
    }

}
