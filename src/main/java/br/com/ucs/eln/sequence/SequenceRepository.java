package br.com.ucs.eln.sequence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SequenceRepository implements PanacheRepository<Sequence> {

    public Sequence getByName(String name) {
        try {
            return find("name = ?1", name).singleResult();
        } catch (Exception e) {
            return generate(name);
        }
    }

    public Sequence generate(String name) {
        var sequence = new Sequence();
        sequence.setName(name);

        persist(sequence);
        return sequence;
    }

}
