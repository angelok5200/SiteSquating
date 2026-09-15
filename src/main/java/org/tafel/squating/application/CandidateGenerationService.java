package org.tafel.squating.application;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.tafel.squating.domain.model.Brand;
import org.tafel.squating.domain.model.CandidateDomain;
import org.tafel.squating.generators.CandidateGenerator;
import org.tafel.squating.ports.inbound.GenerateCandidatesUseCase;
import org.tafel.squating.ports.outbound.BrandRepository;
import org.tafel.squating.ports.outbound.CandidateRepository;



@Service
public class CandidateGenerationService implements GenerateCandidatesUseCase {

    private final CandidateRepository candidateRepository;
    private final CandidateGenerator candidateGenerator;
    private final BrandRepository brandRepository;

    
    public CandidateGenerationService(CandidateRepository candidateRepository, CandidateGenerator candidateGenerator, BrandRepository brandRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateGenerator = candidateGenerator;
        this.brandRepository = brandRepository;
    }

    @Override 
    public void generateforBrand(UUID brandId){
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found with id: " + brandId));

        Set<String> generatedDomains = candidateGenerator.generate(brand.getName());
        Set<String> existingDomains = candidateRepository.findByBrandId(brandId).stream().map(CandidateDomain::getDomain).collect(Collectors.toSet());
        
        for (String domain : generatedDomains) {
            if (existingDomains.contains(domain)) {
                continue; // Skip if the domain already exists
            }
            
            CandidateDomain candidate = new CandidateDomain(UUID.randomUUID(), brandId, domain);
            
            candidateRepository.save(candidate);
        }
    }
}