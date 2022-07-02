package com.github.jaksa97.LeafSaver.stub;

import com.github.jaksa97.LeafSaver.model.entity.DiseaseEntity;
import com.github.jaksa97.LeafSaver.model.entity.DrugEntity;
import com.github.jaksa97.LeafSaver.model.entity.ProducerEntity;
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
        DrugEntity drug1 = new DrugEntity(1, "Drug 1", 1, "Description 1");
        DrugEntity drug2 = new DrugEntity(2, "Drug 2", 1, "Description 2");
        DrugEntity drug3 = new DrugEntity(3, "Drug 3", 1, "Description 3");
        DrugEntity drug4 = new DrugEntity(4, "Drug 4", 1, "Description 4");
        DrugEntity drug5 = new DrugEntity(5, "Drug 5", 1, "Description 5");

        _drugRepository.saveAll(Arrays.asList(drug1, drug2, drug3, drug4, drug5));
    }

    private void initializeDiseases() {
        DiseaseEntity disease1 = new DiseaseEntity(1, "Disease1", "Disease 1");
        DiseaseEntity disease2 = new DiseaseEntity(2, "Disease2", "Disease 2");
        DiseaseEntity disease3 = new DiseaseEntity(3, "Disease3", "Disease 3");
        DiseaseEntity disease4 = new DiseaseEntity(4, "Disease4", "Disease 4");
        DiseaseEntity disease5 = new DiseaseEntity(5, "Disease5", "Disease 5");

        _diseaseRepository.saveAll(Arrays.asList(disease1, disease2, disease3, disease4, disease5));
    }

    private void initializeProducers() {
        ProducerEntity producer1 = new ProducerEntity(1, "Producer 1");
        ProducerEntity producer2 = new ProducerEntity(2, "Producer 2");
        ProducerEntity producer3 = new ProducerEntity(3, "Producer 3");

        _producerRepository.saveAll(Arrays.asList(producer1, producer2, producer3));
    }
}
