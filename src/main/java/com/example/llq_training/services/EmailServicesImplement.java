package com.example.llq_training.services;

import com.example.llq_training.dto.Filter;
import com.example.llq_training.models.EmailThongTinNguoiGui;
import com.example.llq_training.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class EmailServicesImplement implements EmailServices {

    @Autowired
    private EmailRepository emailRepo;

    @Override
    public void insert(EmailThongTinNguoiGui email) {
        emailRepo.save(email);
    }

    @Override
    public List<EmailThongTinNguoiGui> findAll() {
        return emailRepo.findAll();
    }

    @Override
    public EmailThongTinNguoiGui findById(EmailThongTinNguoiGui email) {

        Specification<EmailThongTinNguoiGui> specification = new Specification<EmailThongTinNguoiGui>() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<EmailThongTinNguoiGui> root, CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(
                        criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), email.getId())));
                predicates.add(
                        criteriaBuilder.and(criteriaBuilder.equal(root.get("emailCc"), email.getEmailCc())));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        List<EmailThongTinNguoiGui> list = emailRepo.findAll(specification);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;

    }

    @Override
    public Page<EmailThongTinNguoiGui> filter(Filter filter) {

        Pageable pageable = PageRequest.of(filter.getPage().getPage(), filter.getPage().getSize());
        Specification<EmailThongTinNguoiGui> specification = new Specification<EmailThongTinNguoiGui>() {
            @Serial
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<EmailThongTinNguoiGui> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                String emailCcFilter = filter.getEmailThongTinNguoiGui().getEmailCc();
                String emailToFilter = filter.getEmailThongTinNguoiGui().getEmailTo();
                String sortFilter = filter.getPage().getSort();
                int trangThaiGuiFilter = filter.getEmailThongTinNguoiGui().getTrangThaiGui();
               try {
                   if (trangThaiGuiFilter != 0) {
                       predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("trangThaiGui"), trangThaiGuiFilter)));
                   }

                   if (emailToFilter != null && !Objects.equals(emailCcFilter, "")) {
                       predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("emailTo"), emailToFilter)));
                   }
                   if (emailCcFilter != null && !Objects.equals(emailCcFilter, "")) {
                       predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("emailCc"), emailCcFilter)));
                   }
                   assert sortFilter != null;
                   if(sortFilter.equalsIgnoreCase("asc")){
                       query.orderBy(criteriaBuilder.asc(root.get("id")));
                   }
                   if(sortFilter.equalsIgnoreCase("desc")){
                       query.orderBy(criteriaBuilder.desc(root.get("id")));
                   }
               }catch (Exception e){
                   System.out.println("error: "+ e.getMessage());
               }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };

        return emailRepo.findAll(specification, pageable);
    }


}
