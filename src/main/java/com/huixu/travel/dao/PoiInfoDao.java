package com.huixu.travel.dao;

import com.huixu.travel.entity.Cities;
import com.huixu.travel.entity.POIs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PoiInfoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Cities> getCity(){
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cities> criteria = builder.createQuery(Cities.class);
            criteria.from(Cities.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<POIs> getAllPOI() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<POIs> criteria = builder.createQuery(POIs.class);
            criteria.from(POIs.class);
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

//    public List<POIs> getAllPOI(int cityId) {
//        try (Session session = sessionFactory.openSession()) {
//            Cities city = session.get(Cities.class, cityId);
//            if (city != null) {
//                return city.getPoiList();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return new ArrayList<>();
//    }

//    //use city way
//    public List<POIs> getPOIbyCategory(String category) {
//        try (Session session = sessionFactory.openSession()) {
//            POIs place = session.get(POIs.class, category);
//            if (place != null) {
//                return place.getPoiList();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return new ArrayList<>();
//    }

    public POIs getPOI(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(POIs.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<POIs> getPOIbyCategory(String type) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<POIs> criteria = builder.createQuery(POIs.class);
            Root<POIs> PoiInfo = criteria.from(POIs.class);
            Predicate sightPre = builder.equal(PoiInfo.get("category"), type);
            criteria.where(sightPre);

            TypedQuery<POIs> query = session.createQuery(criteria);
            return query.getResultList();

            //return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
}
