package com.github.jaksa97.LeafSaver.stub;

import com.github.jaksa97.LeafSaver.model.api.disease.DiseaseDto;
import com.github.jaksa97.LeafSaver.model.api.drug.DrugDto;
import com.github.jaksa97.LeafSaver.model.api.producer.ProducerDto;
import com.github.jaksa97.LeafSaver.repository.DiseaseRepository;
import com.github.jaksa97.LeafSaver.repository.DrugRepository;
import com.github.jaksa97.LeafSaver.repository.ProducerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DbInitializer implements CommandLineRunner {

    private final DrugRepository _drugRepository;
    private final DiseaseRepository _diseaseRepository;
    private final ProducerRepository _producerRepository;

    @Override
    public void run(String... args) throws Exception {
//        initializeDrugs();
//        initializeDiseases();
//        initializeProducers();
    }

    private void initializeDrugs() {
        DrugDto drug1 = new DrugDto(1, "Drug 1", 1, "Description 1");
        DrugDto drug2 = new DrugDto(2, "Drug 2", 1, "Description 2");
        DrugDto drug3 = new DrugDto(3, "Drug 3", 1, "Description 3");
        DrugDto drug4 = new DrugDto(4, "Drug 4", 1, "Description 4");
        DrugDto drug5 = new DrugDto(5, "Drug 5", 1, "Description 5");

        _drugRepository.saveAll(Arrays.asList(drug1, drug2, drug3, drug4, drug5));
    }

    private void initializeDiseases() {
        DiseaseDto disease1 = new DiseaseDto(1, "Disease1", "Disease 1");
        DiseaseDto disease2 = new DiseaseDto(2, "Disease2", "Disease 2");
        DiseaseDto disease3 = new DiseaseDto(3, "Disease3", "Disease 3");
        DiseaseDto disease4 = new DiseaseDto(4, "Disease4", "Disease 4");
        DiseaseDto disease5 = new DiseaseDto(5, "Disease5", "Disease 5");

        _diseaseRepository.saveAll(Arrays.asList(disease1, disease2, disease3, disease4, disease5));
    }

    private void initializeProducers() {
        ProducerDto producer1 = new ProducerDto(1, "Producer 1");
        ProducerDto producer2 = new ProducerDto(2, "Producer 2");
        ProducerDto producer3 = new ProducerDto(3, "Producer 3");

        _producerRepository.saveAll(Arrays.asList(producer1, producer2, producer3));
    }
}
