package Negocio;

import java.util.List;

public class FixtureDTO {
    public List<EncuentroDTO> encuentrosDTO;

    public FixtureDTO() {
    }

    public FixtureDTO(List<EncuentroDTO> encuentrosDTO) {
        this.encuentrosDTO = encuentrosDTO;
    }
}
